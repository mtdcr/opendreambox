DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
RDEPENDS_${PN} = "${PN}-data"
INC_PR = "r9"

inherit opendreambox-precompiled-binary

do_install() {
        install -d ${D}/boot ${D}${datadir}/${PN}
        install -m 0755 bootlogo-${MACHINE}.elf.gz ${D}/boot
        install -m 0644 bootlogo-${MACHINE}.jpg ${D}/boot
        for file in *.mvi; do
                install -m 0644 $file ${D}${datadir}/${PN}
                ln -s ${PN}/$file ${D}${datadir}
        done
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES += "${PN}-data"

FILES_${PN} = "/boot/bootlogo-${MACHINE}.elf.gz"
FILES_${PN}-data = "/boot/bootlogo-${MACHINE}.jpg ${datadir}"

pkg_preinst() {
        if [ -z "$D" ] && mountpoint -q /boot; then mount -o remount,rw /boot; fi
}
pkg_prerm() {
        if [ -z "$D" ] && mountpoint -q /boot; then mount -o remount,rw /boot; fi
}
pkg_postinst() {
        if [ -z "$D" ] && mountpoint -q /boot; then mount -o remount,ro /boot; fi
}
pkg_postrm() {
        if [ -z "$D" ] && mountpoint -q /boot; then mount -o remount,ro /boot; fi
}
