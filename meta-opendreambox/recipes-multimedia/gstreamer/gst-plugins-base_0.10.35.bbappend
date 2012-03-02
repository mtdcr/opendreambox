FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream2"

DEPENDS += "cdparanoia orc"

SRC_URI += " \
        file://d3a44541749f413343d5717c464083cef22a74f1.patch \
        file://1e0ddb12aa1c2b13c4bc4a13712ebd7f06a6346e.patch \
        file://samihack.patch \
"
