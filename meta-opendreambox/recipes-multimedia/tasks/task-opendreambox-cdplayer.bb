DESCRIPTION = "OpenDreambox: CD-Player Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
PR = "r2"

inherit task

#
# task-opendreambox-cdplayer
#
DESCRIPTION_${PN} = "OpenDreambox: CD-Player Support"
DEPENDS = "enigma2-plugins"
RDEPENDS_${PN} = "\
 cdfs \
 cdtextinfo \
 enigma2-plugin-extensions-cdinfo \
 gst-plugins-ugly-cdio \
"

