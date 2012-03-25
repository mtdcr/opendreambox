DESCRIPTION = "Dreambox second stage bootloader"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS = "dreambox-buildimage-native"
PROVIDES = "virtual/bootloader"
PRIORITY = "required"
INC_PR = "r7"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

S = "${WORKDIR}"

do_compile() {
        ${DREAMBOX_BUILDIMAGE} \
                --boot-partition ${DREAMBOX_PART0_SIZE}:secondstage-${MACHINE}-${PV}.bin \
                --data-partition 0:/dev/null \
                --data-partition 0:/dev/null \
                > secondstage-${MACHINE}-${PV}.nfi
}
do_install() {
        install -d ${D}${datadir}/${PN}
        install -m 0644 secondstage-${MACHINE}-${PV}.bin ${D}${datadir}/${PN}/secondstage-${MACHINE}.bin
        install -m 0644 secondstage-${MACHINE}-${PV}.nfi ${D}${datadir}/${PN}/secondstage-${MACHINE}.nfi
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
