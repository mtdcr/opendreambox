DESCRIPTION_enigma2-plugin-extensions-browser = "Browse the web"
DESCRIPTION_enigma2-plugin-extensions-cutlisteditor = "Cut movies"
DESCRIPTION_enigma2-plugin-extensions-graphmultiepg = "Graphical program guide"
DESCRIPTION_enigma2-plugin-extensions-modem = "Connect to the internet by modem"
DESCRIPTION_enigma2-plugin-extensions-pictureplayer = "Show photos"
DESCRIPTION_enigma2-plugin-systemplugins-cleanupwizard = "Detect low flash memory"
DESCRIPTION_enigma2-plugin-systemplugins-crashlogautosubmit = "Send crash logs to Dream Multimedia"
DESCRIPTION_enigma2-plugin-systemplugins-minidlnasetup = "DLNA media server (minidlna)"
DESCRIPTION_enigma2-plugin-systemplugins-networkwizard = "General network settings"
DESCRIPTION_enigma2-plugin-systemplugins-positionersetup = "Install a motorized dish"
DESCRIPTION_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "Fine-tune DiSEqC settings"
DESCRIPTION_enigma2-plugin-systemplugins-satfinder = "Find satellites"
DESCRIPTION_enigma2-plugin-systemplugins-skinselector = "Select installed skins"
DESCRIPTION_enigma2-plugin-systemplugins-videomode = "Select custom video modes"
DESCRIPTION_enigma2-plugin-systemplugins-wirelesslan = "Wireless network settings"

RDEPENDS_enigma2-plugin-dreamboxnetwork-core = " \
        python-json \
"
RDEPENDS_enigma2-plugin-extensions-browser = " \
        python-sqlite3 \
"
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = " \
        aio-grab \
"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = " \
        python-compression \
        python-email \
        python-mime \
        python-twisted-mail \
        python-twisted-names \
"
RDEPENDS_enigma2-plugin-systemplugins-minidlnasetup = " \
        minidlna \
"
RDEPENDS_enigma2-plugin-extensions-modem = " \
        dreambox-modem-ppp-scripts \
        ppp \
"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = " \
        python-twisted-web \
"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = " \
        python-twisted-web \
"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = " \
        python-wifi \
        wireless-tools \
        wpa-supplicant \
"

python populate_packages_prepend() {
        enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
        do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
        do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
        do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
        do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
}