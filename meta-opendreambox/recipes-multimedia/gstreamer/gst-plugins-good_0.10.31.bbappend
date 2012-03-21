FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

DEPENDS := "${@oe_filter_out('^(gconf|pulseaudio)$', '${DEPENDS}', d)} orc"

SRC_URI += "file://audioparser-raise-ranks.patch"
