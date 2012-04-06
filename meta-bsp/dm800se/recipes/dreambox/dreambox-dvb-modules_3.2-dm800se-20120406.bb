require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "b9633b7cf909286e0a6b69fe10203720"
SRC_URI[modules.sha256sum] = "61306a8f45515513a316ac2cce750cc1e018cdfb7ad9eba3904beb0c7706e8d1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
