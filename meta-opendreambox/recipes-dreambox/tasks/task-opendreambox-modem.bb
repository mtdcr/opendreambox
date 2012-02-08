DESCRIPTION = "OpenDreambox: Modem task for the OpenDreambox distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
PR = "r1"

inherit task

#
# task-opendreambox-modem
#
DESCRIPTION_${PN} = "OpenDreambox: Modem support"
DEPENDS = "enigma2"
RDEPENDS_${PN} = "\
  dreambox-modem-ppp-scripts \
  enigma2-plugin-extensions-modem \
  kernel-module-ppp-async \
  kernel-module-ppp-deflate \
  kernel-module-ppp-generic \
  ppp \
"

RRECOMMENDS_${PN} = "\
  enigma2-plugin-extensions-trafficinfo \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
