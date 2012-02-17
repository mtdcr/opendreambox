DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRCREV = "${AUTOREV}"
SCHWERKRAFT_PROJECT = "streamproxy"

INETD_SERVICE_NAME = "8001"
INETD_PROGRAM = "${bindir}/streamproxy"

inherit autotools inetd schwerkraft-git
