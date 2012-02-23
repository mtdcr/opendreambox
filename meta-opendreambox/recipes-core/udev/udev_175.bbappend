PR .= "-dream1"

do_install_append() {
	# disable automatic mounts
	sed -e 's,^\(.*/mount\.sh.*\)$,#\1,' -i ${D}${sysconfdir}/udev/rules.d/local.rules
}
