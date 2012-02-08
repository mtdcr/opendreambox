FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-dream1"

SRC_URI += " \
	file://67_init_hddown.dpatch \
	file://92_sata-hddown.dpatch \
"

do_install_append() {
	echo e2:3:respawn:/usr/bin/enigma2.sh >> ${D}/etc/inittab
}
