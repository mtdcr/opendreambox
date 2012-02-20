DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SRCREV = "${AUTOREV}"

SRC_URI = "file://streamproxy.xinetd.in"

SCHWERKRAFT_PROJECT = "streamproxy"

inherit autotools schwerkraft-git

do_configure_append() {
        sed -e 's,@BINDIR@,${bindir},' ${WORKDIR}/streamproxy.xinetd.in > streamproxy.xinetd
}
do_install_append() {
        install -d ${D}${sysconfdir}/xinetd.d
        install -m 644 streamproxy.xinetd ${D}${sysconfdir}/xinetd.d/streamproxy
}

RDEPENDS_${PN} = "xinetd"
