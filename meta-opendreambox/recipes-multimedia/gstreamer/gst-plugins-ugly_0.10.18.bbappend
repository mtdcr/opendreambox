FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

DEPENDS := "${@oe_filter_out('^(mpeg2dec)$', '${DEPENDS}', d)}"

SRC_URI += "file://dvdsubdec-addproperty-singlebuffer.patch"
