DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
LICENSE = "proprietary"
DEPENDS = "jpeg giflib libpng libsigc++-2.0 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native \
	libfribidi libxmlccwrap libdreamdvd gstreamer \
	python-wifi task-opendreambox-qt4 qxmpp-e"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-fcntl gst-plugin-decodebin gst-plugin-decodebin2 python-stringold \
	python-pickle gst-plugin-app \
	gst-plugin-id3demux gst-plugin-mad gst-plugin-ogg gst-plugin-playbin \
	gst-plugin-typefindfunctions gst-plugin-audioconvert gst-plugin-audioresample \
	gst-plugin-wavparse python-netclient gst-plugin-mpegstream \
	gst-plugin-flac gst-plugin-dvbmediasink gst-plugin-mpegdemux gst-plugin-dvdsub \
	gst-plugin-souphttpsrc gst-plugin-mpegaudioparse gst-plugin-subparse \
	gst-plugin-apetag gst-plugin-icydemux gst-plugin-autodetect \
	glibc-gconv-iso8859-15 ethtool"

GST_RTSP_RDEPENDS = "gst-plugin-udp gst-plugin-rtsp gst-plugin-rtp gst-plugin-rtpmanager"
GST_ALSA_RDEPENDS = "gst-plugin-alsa alsa-conf"
GST_MISC_RDEPENDS = "gst-plugin-matroska gst-plugin-isomp4 gst-plugin-vorbis gst-plugin-audioparsers"
GST_DVD_RDEPENDS = "gst-plugin-cdxaparse gst-plugin-cdio gst-plugin-vcdsrc"
GST_BASE_RDEPENDS = "${GST_ALSA_RDEPENDS} ${GST_MISC_RDEPENDS} ${GST_RTSP_RDEPENDS}"

RDEPENDS_append_dm800 = " ${GST_BASE_RDEPENDS} gst-plugin-ivorbisdec"
RDEPENDS_append_dm8000 = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm500hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm800se = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm7020hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"

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
ENIGMA2_BRANCH ?= "experimental"

SRCREV = "71fa0cf0488f36ac2f666c4e08aa536f9e9379a7"

RECIPE_PV := "${PV}"
PV = "${RECIPE_PV}+${@legitimize_package_name(bb.data.getVar('ENIGMA2_BRANCH', d, True))}+gitr${SRCPV}"
PKGV = "${RECIPE_PV}+${@legitimize_package_name(bb.data.getVar('ENIGMA2_BRANCH', d, True))}+gitr${GITPKGV}"

SRC_URI = " \
        ${ENIGMA2_GIT};branch=${ENIGMA2_BRANCH};scmdata=keep \
        file://enigma2-kill-on-exit.patch \
"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts ${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools gitpkgv pkgconfig

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

RCONFLICTS_${PN} = "dreambox-keymaps"
RREPLACES_${PN} = "dreambox-keymaps tuxbox-tuxtxt-32bpp (<= 0.0+cvs20090130-r1)"
