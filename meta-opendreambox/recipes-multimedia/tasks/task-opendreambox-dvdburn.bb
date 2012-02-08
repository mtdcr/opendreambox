DESCRIPTION = "OpenDreambox: DVD-Burn Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
PR = "r0"

inherit task

#
# task-opendreambox-dvdburn
#
DESCRIPTION_${PN} = "OpenDreambox: DVD-Burning Support"
DEPENDS = "enigma2"
RDEPENDS_${PN} = "\
  cdrkit \
  dvd+rw-tools \
  dvdauthor \
  enigma2-plugin-extensions-dvdburn \
  mjpegtools \
  projectx \
  python-imaging \
"

