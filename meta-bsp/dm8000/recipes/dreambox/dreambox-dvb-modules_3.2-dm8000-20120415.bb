require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "b1776b569995f6f58c7be63b64140430"
SRC_URI[modules.sha256sum] = "ad909df8a4c70355be5b6d4d7b30f7503382806266be9ea186f11e32ee8e08bc"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
