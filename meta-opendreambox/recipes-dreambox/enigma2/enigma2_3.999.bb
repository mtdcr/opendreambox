LIC_FILES_CHKSUM = "file://LICENSE;md5=e943a2b66bda2bf828e561a3e6c7ecfc"
DEPENDS = " \
        dreambox-dvbincludes \
        ethtool \
        freetype \
        giflib \
        gstreamer \
        jpeg \
        libbluray \
        libdlsym \
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
SRCREV = "19cc54f1ad3985a19fb078b14c78405c4ec75de3"

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
RDEPENDS_enigma2-plugin-dreamboxnetwork-core = " \
        python-json \
        python-stringold \
        python-twisted-core \
        python-twisted-web \
        python-xml \
"
RDEPENDS_enigma2-plugin-dreamboxnetwork-demo = " \
        python-stringold \
"

require enigma2-common.inc

ENIGMA2_GIT ?= "git://dummy/git/enigma2.git;protocol=git"
LIBUNWIND = "libunwind"
LIBUNWIND_mipsel = ""
