FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-dream1"

SRC_URI += "file://keymap_endianess.patch"

INETD_SERVICE_NAME = "telnet"
INETD_PACKAGES = "busybox"
INETD_PROGRAM = "${sbindir}/telnetd"

do_install_append() {
        install -d ${D}${sysconfdir}/cron/crontabs
}

inherit inetd
