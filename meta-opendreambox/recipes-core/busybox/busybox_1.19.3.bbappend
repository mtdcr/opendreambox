PR .= "-dream1"

SRC_URI += "file://telnetd.xinetd.in"

inherit xinetd

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
