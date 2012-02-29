require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "e56a5ca652ffcdade5e385253039c391"
SRC_URI[modules.sha256sum] = "b19821836ce98d91cbaa78c550a80e0a5c6b3e0d90805992cc8e583344d9fe5a"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
