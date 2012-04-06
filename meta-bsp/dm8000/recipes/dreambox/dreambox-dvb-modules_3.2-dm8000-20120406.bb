require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "3fc7bd4b5ba7501fec79d480ba91bc00"
SRC_URI[modules.sha256sum] = "60b3391daf2f78cfe43d699063968f63e027ae4617232e33067c6a9390863aaa"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
