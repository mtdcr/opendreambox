PR .= "-dream1"

SRC_URI += "file://dropbear.xinetd.in"

inherit xinetd

do_install_append() {
        rm ${D}${sysconfdir}/init.d/dropbear
        rmdir ${D}${sysconfdir}/init.d
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

INITSCRIPT_PACKAGES = "dummy"
INITSCRIPT_NAME = ""
INITSCRIPT_PARAMS = ""
