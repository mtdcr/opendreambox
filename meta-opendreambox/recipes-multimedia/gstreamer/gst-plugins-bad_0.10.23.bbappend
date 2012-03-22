FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream2"

EXTRA_OECONF += "--with-plugins="
# fix "configure: error: cannot run test program while cross compiling"
EXTRA_OECONF += "--disable-mpeg2enc --disable-mplex"

SRC_URI += " \
        file://0001-mpegtsdemux-fix-bd-streamtype-detection.diff.patch \
        file://0002-add-indexing-capabilities-to-generate-a-SPN-PTS-map-.patch \
        file://0003-mpegpsdemux_speedup.diff.patch \
"
