
SRC_URI += "http://dreamboxupdate.com/download/snapshots/enigma2_${PV}_${PACKAGE_ARCH}.tar.bz2;name=${PACKAGE_ARCH}"

S = "${WORKDIR}"

do_compile() {
}
do_install() {
        cp -r enigma2_${PV}_${PACKAGE_ARCH}/* ${D}
}

require enigma2-common.inc
