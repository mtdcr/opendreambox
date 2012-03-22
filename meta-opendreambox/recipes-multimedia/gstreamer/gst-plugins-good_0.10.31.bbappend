FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream2"

DEPENDS := "${@oe_filter_out('^(gconf|pulseaudio)$', '${DEPENDS}', d)}"

SRC_URI += "file://audioparser-raise-ranks.patch"
