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
SRCREV = "134854b10624ddb8eaaac775284b6767a0a11fd4"

SRC_URI = "${ENIGMA2_GIT};branch=master;protocol=ssh;scmdata=keep"

inherit autotools gettext git-project pkgconfig

EXTRA_OECONF = " \
        BUILD_SYS=${BUILD_SYS} \
        HOST_SYS=${HOST_SYS} \
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        ac_cv_path_MOC=${STAGING_BINDIR_NATIVE}/moc4 \
"
EXTRA_OECONF_append_mipsel = " --without-libunwind"

python () {
        if not d.getVar('ENIGMA2_GIT', True):
                raise bb.parse.SkipPackage('ENIGMA2_GIT has not been set')
}

require enigma2-common.inc
