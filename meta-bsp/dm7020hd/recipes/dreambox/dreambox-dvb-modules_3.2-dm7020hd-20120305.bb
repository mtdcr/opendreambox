require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "39e6f8c0d45afd36a4ac6a2fb4d38a54"
SRC_URI[modules.sha256sum] = "520fc1e33b50d85746fadceb6dfeb5ad7dba02ebd6c0066fce8a44ca8c187ed5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
