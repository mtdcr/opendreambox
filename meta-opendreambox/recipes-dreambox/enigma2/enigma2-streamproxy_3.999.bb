DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SRCREV = "${AUTOREV}"

SRC_URI = "file://streamproxy.xinetd.in"

SCHWERKRAFT_PROJECT = "streamproxy"

inherit autotools schwerkraft-git xinetd
