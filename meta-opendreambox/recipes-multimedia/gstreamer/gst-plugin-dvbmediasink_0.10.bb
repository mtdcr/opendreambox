DESCRIPTION = "Plugin for gstreamer: dvbmediasink"
LICENSE = "MIT | LGPLv2.1"
LIC_FILES_CHKSUM = "file://src/gstdvbaudiosink.c;beginline=1;endline=45;md5=023ebb8eaef9b8cce8591a9d96638392 \
                    file://src/gstdvbvideosink.c;beginline=1;endline=44;md5=b597d3f0a4e3b49db42d2b5140bd7004"
SECTION = "multimedia"
DEPENDS = "gstreamer gst-plugins-base"
PR = "r1"

SRCREV = "${AUTOREV}"
SCHWERKRAFT_PROJECT = "dvbmediasink"

inherit autotools schwerkraft-git

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la \
        ${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
