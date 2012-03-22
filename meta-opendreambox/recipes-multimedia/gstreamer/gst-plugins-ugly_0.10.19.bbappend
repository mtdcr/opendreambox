FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream2"

EXTRA_OECONF += "--with-plugins="

SRC_URI += "file://dvdsubdec-addproperty-singlebuffer.patch"
