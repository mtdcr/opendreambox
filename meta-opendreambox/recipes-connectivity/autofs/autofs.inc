DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"
INC_PR = "r4"
EXTRA_OEMAKE += "'RANLIB=${RANLIB}'"

inherit autotools

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	install -d ${D}${mandir}/man5 ${D}${mandir}/man8 \
		   ${D}${sbindir}
	oe_runmake 'INSTALLROOT=${D}' install
}
