
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} += "libsigc++-1.2"

require enigma2-bin-common.inc

INSANE_SKIP_${PN} = "dev-so"
