LIC_FILES_CHKSUM = "file://LICENSE;md5=e943a2b66bda2bf828e561a3e6c7ecfc"
DEPENDS = " \
        dreambox-dvbincludes \
        freetype \
        giflib \
        gstreamer \
        jpeg \
        libbluray \
        libdreamdvd \
        libdvbsi++ \
        libfribidi \
        libpng \
        libsigc++-2.0 \
        ${LIBUNWIND} \
        libxml2 \
        libxmlccwrap \
        minidlna \
        python \
        python-wifi \
        qt4-embedded \
        qxmpp-e \
        swig-native \
"
SRCREV = "78d3dc07baf998b29b3365c2c4c7446e63f2c1ca"

SRC_URI = "${ENIGMA2_GIT};scmdata=keep"

inherit autotools gettext git-project pkgconfig

EXTRA_OECONF = " \
        BUILD_SYS=${BUILD_SYS} \
        HOST_SYS=${HOST_SYS} \
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        ac_cv_path_MOC=${STAGING_BINDIR_NATIVE}/moc4 \
"
EXTRA_OECONF_append_mipsel = " --without-libunwind"

RDEPENDS_${PN} += " \
        qt4-embedded-fonts-ttf-dejavu \
        qt4-embedded-fonts-ttf-vera \
"

require enigma2-common.inc

ENIGMA2_GIT ?= "git://dummy/git/enigma2.git;protocol=git"
LIBUNWIND = "libunwind"
LIBUNWIND_mipsel = ""
