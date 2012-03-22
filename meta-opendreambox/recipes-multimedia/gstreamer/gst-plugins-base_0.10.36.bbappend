DEPENDS += "cdparanoia orc orc-native"
PR .= "-dream1"

SRC_URI += " \
        file://samihack.patch \
"

EXTRA_OECONF += "--enable-orc"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
