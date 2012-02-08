FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR .= "-dream1"

SRC_URI += " \
	file://bootup \
"

S = "${WORKDIR}"

do_install() {
	for dir in init.d rcS.d rc0.d rc1.d rc2.d rc3.d rc4.d rc5.d rc6.d; do
		install -d ${D}${sysconfdir}/$dir
	done

	for file in halt reboot populate-volatile.sh sendsigs single umountfs; do
		install -m 0755 $file ${D}${sysconfdir}/init.d
	done

	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 volatiles ${D}${sysconfdir}/default/volatiles/00_core

	for file in bootup devpts.sh populate-volatile.sh sysfs.sh; do
		install -m 0755 $file ${D}${sysconfdir}/init.d
	done

	install -m 0644 devpts ${D}${sysconfdir}/default

	install -d ${D}${sysconfdir}/network/if-up.d
	install -m 0755 mountnfs.sh ${D}${sysconfdir}/network/if-up.d/02mountnfs
	install -d ${D}${sysconfdir}/network/if-down.d
	install -m 0755 umountnfs.sh ${D}${sysconfdir}/network/if-down.d/02umountnfs

	update-rc.d -r ${D} sysfs.sh			start  3 S .
	update-rc.d -r ${D} bootup			start  5 S .
	update-rc.d -r ${D} populate-volatile.sh	start 37 S .
	update-rc.d -r ${D} devpts.sh			start 38 S .

	update-rc.d -r ${D} sendsigs		start 20 0 6 .
	update-rc.d -r ${D} umountfs		start 40 0 6 .
	update-rc.d -r ${D} halt		start 90 0 .
	update-rc.d -r ${D} reboot		start 90 6 .
}
