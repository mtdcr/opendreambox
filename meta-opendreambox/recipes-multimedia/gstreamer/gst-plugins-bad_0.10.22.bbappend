FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

DEPENDS += "orc"

EXTRA_OECONF += "--with-plugins="
# fix "configure: error: cannot run test program while cross compiling"
EXTRA_OECONF += "--disable-mpeg2enc"

SRC_URI += " \
        file://mpegtsdemux-fix-bd-streamtype-detection.diff \
        file://mpegpsdemux_speedup.diff;striplevel=0 \
        file://mpegtsmux_indexing_alignment.diff \
"
