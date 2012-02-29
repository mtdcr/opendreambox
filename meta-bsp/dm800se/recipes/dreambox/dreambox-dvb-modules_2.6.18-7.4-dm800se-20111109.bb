require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "9499058b4bc8090dc7031e6af7ba16a0"
SRC_URI[modules.sha256sum] = "19a51e6484ead5f7f32476e8a7bc6aac4ada2390f575d1d77590b82187ef904c"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
