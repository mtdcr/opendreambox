DEPENDS = " \
        dreambox-dvbincludes \
        freetype \
        giflib \
        gstreamer \
        jpeg \
        libdreamdvd \
        libdvbsi++ \
        libfribidi \
        libpng \
        libsigc++-2.0 \
        libxmlccwrap \
        minidlna \
        python \
        python-wifi \
        qt4-embedded \
        qxmpp-e \
        swig-native \
"
SRCREV = "01bcb58a12fe09841bf59cf0417ce680ed8ccbef"

SRC_URI = "${ENIGMA2_GIT};branch=master;scmdata=keep"

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

python () {
        if not d.getVar('ENIGMA2_GIT', True):
                raise bb.parse.SkipPackage('ENIGMA2_GIT has not been set')
}

require enigma2-common.inc
