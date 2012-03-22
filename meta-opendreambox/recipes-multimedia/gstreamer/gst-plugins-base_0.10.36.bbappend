FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream2"

DEPENDS += "cdparanoia orc orc-native"

SRC_URI += " \
        file://samihack.patch \
"
