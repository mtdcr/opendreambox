require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "35a045e11bd50ee563b5c9fbb3094534"
SRC_URI[modules.sha256sum] = "467f74e54e62523e3cb385e7b3d27b8f4d5e1203408f9d5f1d76740ba14c8c2a"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
