FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

DEPENDS += "orc"

EXTRA_OECONF += "--with-plugins="

SRC_URI += "file://dvdsubdec-addproperty-singlebuffer.patch"
