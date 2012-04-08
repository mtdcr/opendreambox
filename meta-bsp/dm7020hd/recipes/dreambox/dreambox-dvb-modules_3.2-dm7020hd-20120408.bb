require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "6c9e1f058a8621287a5195518cd9d82d"
SRC_URI[modules.sha256sum] = "d751e22547d30a85689881ec192104d3f3017c45e61389f2b053b9379ff30a0e"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
