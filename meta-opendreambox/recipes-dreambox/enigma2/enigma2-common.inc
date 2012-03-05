DESCRIPTION = "Framebuffer-based digital media application"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e943a2b66bda2bf828e561a3e6c7ecfc"

PACKAGES += "${PN}-meta"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} += " \
        alsa-conf \
        ethtool \
        glibc-gconv-iso8859-15 \
        gst-plugin-dvbmediasink \
        ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'gst-plugins-bad-cdxaparse', '', d)} \
        gst-plugins-bad-mpegdemux \
        ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'gst-plugins-bad-vcdsrc', '', d)} \
        gst-plugins-base-alsa \
        gst-plugins-base-app \
        gst-plugins-base-audioconvert \
        gst-plugins-base-audioresample \
        gst-plugins-base-decodebin \
        gst-plugins-base-decodebin2 \
        gst-plugins-base-ogg \
        gst-plugins-base-playbin \
        gst-plugins-base-subparse \
        gst-plugins-base-typefindfunctions \
        ${@base_conditional('TARGET_FPU', 'soft', 'gst-plugins-base-ivorbisdec', 'gst-plugins-base-vorbis', d)} \
        gst-plugins-good-apetag \
        gst-plugins-good-audioparsers \
        gst-plugins-good-autodetect \
        ${@base_contains('DREAMBOX_FEATURES', 'xvid', 'gst-plugins-good-avi', '', d)} \
        gst-plugins-good-flac \
        gst-plugins-good-icydemux \
        gst-plugins-good-id3demux \
        gst-plugins-good-isomp4 \
        gst-plugins-good-matroska \
        gst-plugins-good-rtp \
        gst-plugins-good-rtpmanager \
        gst-plugins-good-rtsp \
        gst-plugins-good-souphttpsrc \
        gst-plugins-good-udp \
        gst-plugins-good-wavparse \
        ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'gst-plugins-ugly-cdio', '', d)} \
        gst-plugins-ugly-dvdsub \
        gst-plugins-ugly-mad \
        gst-plugins-ugly-mpegaudioparse \
        gst-plugins-ugly-mpegstream \
        python-codecs \
        python-core \
        python-fcntl \
        python-lang \
        python-netclient \
        python-pickle \
        python-re \
        python-shell \
        python-stringold \
        python-threading \
        python-xml \
"

FILES_${PN} += "${datadir}/fonts ${datadir}/keymaps ${libdir}/libopen.so"
FILES_${PN}-meta = "${datadir}/meta"

require enigma2-core-plugins.inc
