DESCRIPTION = "Framebuffer-based digital media application"
LICENSE = "Proprietary"

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
