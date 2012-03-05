DESCRIPTION = "Framebuffer-based digital media application"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e943a2b66bda2bf828e561a3e6c7ecfc"

PACKAGES += "${PN}-meta"

RDEPENDS_${PN} += " \
        alsa-conf \
        ethtool \
        glibc-gconv-iso8859-15 \
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
