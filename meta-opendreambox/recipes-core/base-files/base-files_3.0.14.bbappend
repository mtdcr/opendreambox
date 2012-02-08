FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-dream1"

do_install_append() {
	rm -rf ${D}/mnt
	rm -rf ${D}/hdd
	ln -sf media/hdd ${D}/hdd
	ln -sf media ${D}/mnt
}
