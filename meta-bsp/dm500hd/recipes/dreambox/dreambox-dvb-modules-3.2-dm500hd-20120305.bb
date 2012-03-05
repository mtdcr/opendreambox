require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "e1cffa1030b55ce516a3a0f89526ff07"
SRC_URI[modules.sha256sum] = "d585d94bc10adfa77f923c3e80b718974b6513e9ceaa2e80ebd9154273714180"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
