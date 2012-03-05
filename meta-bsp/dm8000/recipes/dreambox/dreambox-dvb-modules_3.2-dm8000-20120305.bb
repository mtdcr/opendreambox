require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "3685495aadc85a0e4d3d0e1d34db1079"
SRC_URI[modules.sha256sum] = "1b2e39786c686a2cddf500b3c6e0f4d11a105846fc4f6b474e10c03ea3848311"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
