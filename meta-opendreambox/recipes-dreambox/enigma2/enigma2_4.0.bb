DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e943a2b66bda2bf828e561a3e6c7ecfc"

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

RDEPENDS = " \
	alsa-conf \
	ethtool \
	glibc-gconv-iso8859-15 \
	gst-plugin-dvbmediasink \
	gst-plugins-bad-mpegdemux \
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
	python-stringold \
	python-threading \
	python-xml \
"

GST_DVD_RDEPENDS = "gst-plugins-bad-cdxaparse gst-plugins-ugly-cdio gst-plugins-bad-vcdsrc"

RDEPENDS_append_dm8000 = " ${GST_DVD_RDEPENDS} gst-plugins-good-avi"
RDEPENDS_append_dm500hd = " ${GST_DVD_RDEPENDS} gst-plugins-good-avi"
RDEPENDS_append_dm800se = " ${GST_DVD_RDEPENDS} gst-plugins-good-avi"
RDEPENDS_append_dm7020hd = " ${GST_DVD_RDEPENDS} gst-plugins-good-avi"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

DESCRIPTION_append_enigma2-plugin-extensions-browser = "a basic webbrowser for surfing the web."
RDEPENDS_enigma2-plugin-extensions-browser = "python-sqlite3"
DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-minidlnasetup = "setup a dlna mediaserver based on minidlna."
RDEPENDS_enigma2-plugin-systemplugins-minidlnasetup = "minidlna"
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
RCONFLICTS_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
RREPLACES_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "python-twisted-mail python-twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extensions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts ppp"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"

ENIGMA2_GIT ?= "git://git.opendreambox.org/git/enigma2.git;protocol=git"
ENIGMA2_BRANCH ?= "master"

SRCREV = "134854b10624ddb8eaaac775284b6767a0a11fd4"

RECIPE_PV := "${PV}"
PV = "${RECIPE_PV}+${@legitimize_package_name(bb.data.getVar('ENIGMA2_BRANCH', d, True))}+gitr${SRCPV}"
PKGV = "${RECIPE_PV}+${@legitimize_package_name(bb.data.getVar('ENIGMA2_BRANCH', d, True))}+gitr${GITPKGV}"

SRC_URI = "${ENIGMA2_GIT};branch=${ENIGMA2_BRANCH};scmdata=keep"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts ${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools gettext gitpkgv pkgconfig

EXTRA_OECONF = " \
        BUILD_SYS=${BUILD_SYS} \
        HOST_SYS=${BASEPKG_HOST_SYS} \
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        ac_cv_path_MOC=${STAGING_BINDIR_NATIVE}/moc4 \
"
EXTRA_OECONF_append_mipsel = " --without-libunwind"

python populate_packages_prepend() {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.l?a$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
}
