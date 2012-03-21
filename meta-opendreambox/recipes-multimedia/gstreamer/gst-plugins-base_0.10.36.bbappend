FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

DEPENDS += "cdparanoia orc"

SRC_URI += " \
        file://samihack.patch \
"
