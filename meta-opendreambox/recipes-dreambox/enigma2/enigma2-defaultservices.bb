DESCRIPTION = "enigma2 default services/transponder"
LICENSE = "Proprietary"
PR = "r5"

SRC_URI = "file://*"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/usr/share/enigma2/dealer
        install ${WORKDIR}/*.info ${D}/usr/share/enigma2/dealer
        install ${WORKDIR}/lamedb.* ${D}/usr/share/enigma2/dealer
}

PACKAGE_ARCH = "all"

FILES_${PN} = "/"
