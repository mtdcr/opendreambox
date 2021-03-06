DESCRIPTION = "Hardware drivers for Dreambox"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS += "virtual/kernel"
PRIORITY = "required"
INC_PR = "r6"

DREAMBOX_DVB_MODULES_MIRROR ?= "http://sources.dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-dvb-modules"

SRC_URI = " \
        ${DREAMBOX_DVB_MODULES_MIRROR}/dreambox-dvb-modules-${MACHINE}-${PV}.tar.bz2;name=modules \
        file://modules \
"

inherit module

do_compile() {
}
do_install() {
        install -d ${D}${sysconfdir}/modules-load.d
        install -m 0644 ${WORKDIR}/modules ${D}${sysconfdir}/modules-load.d/${PN}.conf
        install -d ${D}/lib/modules/${DM_LOCALVERSION}/extra
        install -m 0644 ${WORKDIR}/LICENSE ${D}/lib/modules/${DM_LOCALVERSION}/extra
        install -m 0644 ${WORKDIR}/*.ko ${D}/lib/modules/${DM_LOCALVERSION}/extra
}

PACKAGES = "${PN}"

RDEPENDS_${PN} += "dreambox-secondstage kernel-${DM_LOCALVERSION}"

python __anonymous () {
        import bb, re
        kv = bb.data.getVar('DREAMBOX_KERNEL_VERSION', d, 1)
        pv = bb.data.getVar('PV', d, 1)
        if kv != pv.split('-')[0]:
                raise bb.parse.SkipPackage("incompatible with kernel version %s" % kv)
}

# We don't use KERNEL_VERSION in this recipe, because the
# precompiled modules depend on a specific version.
DM_LOCALVERSION = "${@'-'.join('${PV}'.split('-')[:-1])}"
