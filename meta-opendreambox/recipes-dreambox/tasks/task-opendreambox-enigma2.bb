DESCRIPTION = "OpenDreambox: Enigma2 Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
PR = "r11"

inherit task

PROVIDES = "\
  task-opendreambox-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opendreambox-enigma2 \
"

#
# task-opendreambox-enigma2
#
RPROVIDES_task-opendreambox-enigma2 = "task-opendreambox-ui"
DESCRIPTION_task-opendreambox-enigma2 = "OpenDreambox: Enigma2 Dependencies"
RDEPENDS_task-opendreambox-enigma2 = "\
  ${@base_contains('DREAMBOX_NIMS', 'cxd1978', 'blindscan-cxd1978', '', d)} \
  ${@base_contains('DREAMBOX_NIMS', 'slot', 'blindscan-utils', '', d)} \
  enigma2 \
  enigma2-defaultservices \
  enigma2-drivers-meta \
  enigma2-meta \
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-extensions-mediascanner \
  ${@base_contains('DREAMBOX_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
  enigma2-plugin-systemplugins-frontprocessorupgrade \
  enigma2-plugin-systemplugins-hotplug \
  enigma2-plugin-systemplugins-networksetup \
  enigma2-plugin-systemplugins-networkwizard \
  enigma2-plugin-systemplugins-softwaremanager \
  ${@base_contains('DREAMBOX_FEATURES', 'fan', 'enigma2-plugin-systemplugins-tempfancontrol', '', d)} \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-videotune \
  enigma2-plugins-meta \
  enigma2-skins-meta \
  enigma2-streamproxy \
  ${@base_contains('DREAMBOX_FEATURES', 'libpassthrough', 'libpassthrough', '', d)} \
  task-opendreambox-qt4 \
  tuxbox-tuxtxt-32bpp \
"

RRECOMMENDS_task-opendreambox-enigma2 = "\
  aio-grab \
  enigma2-plugin-extensions-audiosync \
  enigma2-plugin-extensions-cutlisteditor \
  enigma2-plugin-extensions-graphmultiepg \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-extensions-webbouqueteditor \
  enigma2-plugin-extensions-webinterface \
  enigma2-plugin-systemplugins-crashlogautosubmit \
  enigma2-plugin-systemplugins-positionersetup \
  enigma2-plugin-systemplugins-satfinder \
  enigma2-plugin-systemplugins-skinselector \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  python-zopeinterface \
  ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'task-opendreambox-cdplayer', '', d)} \
  ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'task-opendreambox-dvdburn', '', d)} \
  ${@base_contains('DREAMBOX_FEATURES', 'dvd', 'task-opendreambox-dvdplayer', '', d)} \
  ${@base_contains('MACHINE_FEATURES', 'modem', 'task-opendreambox-modem', '', d)} \
  ${@base_contains('MACHINE_FEATURES', 'wifi', 'task-opendreambox-wlan', '', d)} \
"

RDEPENDS_task-opendreambox-enigma2_append_dm8000 = " \
  enigma2-plugin-systemplugins-nfiflash \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
