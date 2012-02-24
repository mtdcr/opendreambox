PR .= "-dream2"

do_install_append() {
        echo "S:5:respawn:${base_sbindir}/getty ttyS0 115200" >> ${D}${sysconfdir}/inittab
        echo "e2:3:respawn:${bindir}/enigma2.sh" >> ${D}${sysconfdir}/inittab
}
