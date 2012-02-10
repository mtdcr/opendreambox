DESCRIPTION = "OpenDreambox: Qt4 packages"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
DEPENDS = "qt4-embedded"
RRECOMMENDS_${PN} = " \
        qt4-embedded-fonts \
        qt4-embedded-plugin-gfxdriver-screenvfb \
        qt4-embedded-plugin-imageformat-gif \
        qt4-embedded-plugin-imageformat-ico \
        qt4-embedded-plugin-imageformat-jpeg \
        qt4-embedded-plugin-imageformat-mng \
        qt4-embedded-plugin-imageformat-svg \
        qt4-embedded-plugin-imageformat-tiff \
        qt4-embedded-plugin-phonon-backend-gstreamer \
        qt4-embedded-plugin-sqldriver-sqlite2 \
"
PR = "r1"

inherit task
