PR .= "-dream2"

do_install_append() {
        ln -s media/hdd ${D}/hdd

        rm -r ${D}/mnt
        ln -s media ${D}/mnt

        rmdir ${D}/tmp
        ln -s var/tmp ${D}/tmp
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
