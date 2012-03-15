DEPENDS = "freetype gstreamer libdreamdvd libfribidi libpng libsigc++-1.2 libxml2 libxmlccwrap openssl"
INC_PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Shlibs can't find them. See dreambox-compat.
RDEPENDS_${PN} += "giflib jpeg libdvbsi++ libpython2"

require enigma2-bin-common.inc

INSANE_SKIP_${PN} = "dev-so"