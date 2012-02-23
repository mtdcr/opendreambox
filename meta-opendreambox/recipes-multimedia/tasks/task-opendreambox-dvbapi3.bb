DESCRIPTION = "OpenDreambox: DVB API v3 Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
PR = "r3"

inherit task

#
# task-opendreambox-dvbapi3
#
DESCRIPTION_${PN} = "OpenDreambox: DVB API v3 Dependencies"
RDEPENDS_${PN} = "\
  dvbsnoop \
  showiframe \
"

