FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-bsp3"

SRC_URI += " \
        file://fscking.raw \
"

do_install_append() {
        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/fscking.raw ${D}${sysconfdir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
