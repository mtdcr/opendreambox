FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

SRC_URI += " \
        file://mpegtsdemux-fix-bd-streamtype-detection.diff \
        file://mpegpsdemux_speedup.diff;striplevel=0 \
        file://mpegtsmux_indexing_alignment.diff \
"
