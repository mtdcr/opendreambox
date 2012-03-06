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
SRCREV = "c742400e09ce69fe07408b9e18f4ff1f336ac9df"

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
