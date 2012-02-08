PR .= "-dream1"

SRC_URI += " \
	file://auto.hotplug \
	file://auto.master \
	file://auto.network \
	file://autofs \
"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/autofs ${D}${sysconfdir}/init.d
	install ${WORKDIR}/auto.hotplug ${D}${sysconfdir}/auto.hotplug
	install ${WORKDIR}/auto.master ${D}${sysconfdir}/auto.master
	install ${WORKDIR}/auto.network ${D}${sysconfdir}/auto.network
}
