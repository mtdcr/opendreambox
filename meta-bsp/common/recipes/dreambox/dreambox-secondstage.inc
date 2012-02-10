DESCRIPTION = "Dreambox second stage bootloader"
LICENSE = "Proprietary"
SECTION = "base"
PRIORITY = "required"
PROVIDES = "virtual/bootloader"
INC_PR = "r3"

SRC_URI = " \
        http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin;name=second-bin \
        http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.nfi;name=second-nfi \
        http://sources.dreamboxupdate.com/download/7020/writenfi-mipsel-2.6.18-r1;name=writenfi \
"
SRC_URI[writenfi.md5sum] = "4e3b85f725dcf3ff1e8eb08e5a139ce2"
SRC_URI[writenfi.sha256sum] = "5741602b540e9b2256c7ce7cdfd2140185edb4b43eeeccae87aaa98b48c37c8e"

do_install() {
        install -d ${D}${datadir}/${PN}
        install -m 0644 ${WORKDIR}/secondstage-${MACHINE}-${PV}.bin ${D}${datadir}/${PN}/secondstage-${MACHINE}.bin
        install -d ${D}/tmp
        install -m 0644 ${WORKDIR}/secondstage-${MACHINE}-${PV}.nfi ${D}/tmp/secondstage.nfi
        install -m 0755 ${WORKDIR}/writenfi-mipsel-2.6.18-r1 ${D}/tmp/writenfi
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES =+ "${PN}-bin"

FILES_${PN} = "/tmp"
FILES_${PN}-bin = "${datadir}/${PN}/secondstage-${MACHINE}.bin"

pkg_postinst() {
        if [ "x$D" != "x" ]; then
                exit 1
        fi
        if [ -f /tmp/writenfi ]; then
                /tmp/writenfi /tmp/secondstage.nfi
                rm /tmp/writenfi /tmp/secondstage.nfi
        fi
}
