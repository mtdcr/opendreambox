require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "71f312ac830a12cb5a395ce4f27e7e20"
SRC_URI[modules.sha256sum] = "990b3a4d504a2ea36ed8767c3c3e2c65a2fef1ef4a07e61247608bec9fc09cdf"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
