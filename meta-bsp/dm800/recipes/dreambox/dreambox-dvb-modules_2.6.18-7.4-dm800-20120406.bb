require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "e76539257ffe258b2ec9cdcab8ad5c0a"
SRC_URI[modules.sha256sum] = "ff1de93593490ed3f44d330ea83590dcc30ab84f533af689f825ba38a1ff66e5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
