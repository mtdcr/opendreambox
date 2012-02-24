PR .= "-dream2"

SRC_URI += " \
        file://67_init_hddown.dpatch \
        file://92_sata-hddown.dpatch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
