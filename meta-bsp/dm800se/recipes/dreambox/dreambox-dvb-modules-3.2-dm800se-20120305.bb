require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "5838c7756f1d2b55bb906753190f266f"
SRC_URI[modules.sha256sum] = "7ada80b65b0751e5b81f184a2102a9726aec591cede6b71662c5ecebfcf98832"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
