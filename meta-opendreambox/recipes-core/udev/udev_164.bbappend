FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-dream1"

SRC_URI += "${@base_conditional('DREAMBOX_KERNEL_VERSION', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"

do_install_append() {
	if [ -f ${WORKDIR}/41-od-linux-2.6.18-misc.rules ]; then
		install -m 0644 ${WORKDIR}/41-od-linux-2.6.18-misc.rules ${D}${sysconfdir}/udev/rules.d
	fi
	# disable automatic mounts
	sed -e 's,^\(.*/mount\.sh.*\)$,#\1,' -i ${D}${sysconfdir}/udev/rules.d/local.rules
}
