PR .= "-dream2"

do_install_append() {
	rm ${D}${sysconfdir}/*.d/*save-rtc.sh
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
