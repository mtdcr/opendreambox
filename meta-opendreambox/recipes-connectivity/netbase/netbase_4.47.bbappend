FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-dream1"

# update-inetd depends on perl and is
# used by netkit-telnet only.
do_install_append() {
	rm ${D}${sbindir}/update-inetd
	rm ${D}${mandir}/man8/update-inetd.8
}
