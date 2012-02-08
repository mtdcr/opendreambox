PR .= "-dream1"

SRC_URI += " \
	file://ushare.sh \
	file://ushare.conf \
	file://ts.patch \
"

inherit update-rc.d

INITSCRIPT_NAME = "ushare"
INITSCRIPT_PARAMS = "defaults 40 20"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/ushare.sh ${D}/etc/init.d/ushare
	install -m 0644 ${WORKDIR}/ushare.conf ${D}/etc/ushare.conf
}
