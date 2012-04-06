require recipes/dreambox/dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "1923f0cbc46be496b6e1bbd48e9ffc7d"
SRC_URI[modules.sha256sum] = "3cf139e77b56a6909b6d2353ed5e84ec106dc70c4925aad6c07376413492da2a"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
