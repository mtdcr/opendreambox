DESCRIPTION = "Dreambox second stage bootloader"
SECTION = "base"
LICENSE = "CLOSED"
PROVIDES = "virtual/bootloader"
PRIORITY = "required"
INC_PR = "r6"

SRC_URI = " \
        http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin;name=second-bin \
        http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.nfi;name=second-nfi \
"

do_install() {
        install -d ${D}${datadir}/${PN}
        install -m 0644 ${WORKDIR}/secondstage-${MACHINE}-${PV}.bin ${D}${datadir}/${PN}/secondstage-${MACHINE}.bin
        install -m 0644 ${WORKDIR}/secondstage-${MACHINE}-${PV}.nfi ${D}${datadir}/${PN}/secondstage-${MACHINE}.nfi
}

PACKAGES = "${PN} ${PN}-bin"

PACKAGE_ARCH := "${MACHINE_ARCH}"

RDEPENDS_${PN} = "writenfi"

FILES_${PN} = "${datadir}/${PN}/secondstage-${MACHINE}.nfi"
FILES_${PN}-bin = "${datadir}/${PN}/secondstage-${MACHINE}.bin"

pkg_postinst_${PN}() {
if [ -z "$D" ]; then
        ${bindir}/writenfi ${datadir}/${PN}/secondstage-${MACHINE}.nfi
fi
}
