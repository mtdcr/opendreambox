#
# inetd.bbclass
#
# based on update-rc.d.bbclass
#

INETD_PACKAGES ?= "${PN}"

INETD_SERVICE_NAME ?= ""
INETD_SOCKET_TYPE ?= "stream"
INETD_PROTOCOL ?= "tcp"
INETD_WAIT ?= "nowait"
INETD_USER ?= "root"
INETD_PROGRAM ?= "${sbindir}/${PN}"
INETD_PROGRAM_ARGS ?= "${@os.path.basename(d.getVar('INETD_PROGRAM', True))}"

INETD_CONF = "${sysconfdir}/inetd.conf"
INETD_PARAMS = "${INETD_SERVICE_NAME} ${INETD_SOCKET_TYPE} ${INETD_PROTOCOL} ${INETD_WAIT} ${INETD_USER} ${INETD_PROGRAM} ${INETD_PROGRAM_ARGS}"
INETD_PATTERN = '^\(#\s*\)\?${@"${INETD_PARAMS}".replace(" ", "\s\+").replace("/", "\/")}\s*$'

#
# inetd_postinst
#
# Adds a line to inetd.conf, one service per package. The new
# service will be disabled if another active service already
# uses its name.
#

inetd_postinst() {
grep -q '^${INETD_SERVICE_NAME}\s' $D${INETD_CONF} && echo -n '#' >> $D${INETD_CONF}
echo '${INETD_PARAMS}' >> $D${INETD_CONF}
PID=`pidof inetd` && kill -HUP $PID || true
}

#
# inetd_prerm
#
# Removes the service from inetd.conf. Tolerates changed spacing
# and a leading number sign.
#

inetd_prerm() {
sed -e '/${INETD_PATTERN}/d' -i $D${INETD_CONF}
PID=`pidof inetd` && kill -HUP $PID || true
}

def inetd_after_parse(d):
        if bb.data.getVar('INETD_SERVICE_NAME', d) == None:
            raise bb.build.FuncFailed, "%s inherits inetd but doesn't set INETD_SERVICE_NAME" % bb.data.getVar('FILE', d)

python __anonymous() {
    inetd_after_parse(d)
}

python populate_packages_prepend () {
	def inetd_package(pkg):
		bb.debug(1, 'adding inetd calls to postinst/prerm for %s' % pkg)
		localdata = bb.data.createCopy(d)
		overrides = bb.data.getVar("OVERRIDES", localdata, 1)
		bb.data.setVar("OVERRIDES", "%s:%s" % (pkg, overrides), localdata)
		bb.data.update_data(localdata)

		postinst = '#!/bin/sh\n'
		try:
			postinst += bb.data.getVar('pkg_postinst', localdata, 1)
		except:
			pass
		postinst += bb.data.getVar('inetd_postinst', localdata, 1)
		bb.data.setVar('pkg_postinst_%s' % pkg, postinst, d)
		prerm = bb.data.getVar('pkg_prerm', localdata, 1)
		if not prerm:
			prerm = '#!/bin/sh\n'
		prerm += bb.data.getVar('inetd_prerm', localdata, 1)
		bb.data.setVar('pkg_prerm_%s' % pkg, prerm, d)

		rdepends = (bb.data.getVar('RDEPENDS', localdata, 1) or "").split()
		rdepends.append("inetd")
		bb.data.setVar('RDEPENDS_%s' % pkg, " ".join(rdepends), d)

	pkgs = bb.data.getVar('INETD_PACKAGES', d, 1)
	if pkgs == None:
		pkgs = bb.data.getVar('PN', d, 1)
		packages = (bb.data.getVar('PACKAGES', d, 1) or "").split()
		if not pkgs in packages and packages != []:
			pkgs = packages[0]
	for pkg in pkgs.split():
		inetd_package(pkg)
}
