DESCRIPTION = "kernel-based automounter for Linux"
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"
PR = "r6"

SRC_URI = "${KERNELORG_MIRROR}/linux/daemons/autofs/v4/${BP}.tar.bz2;name=archive \
           ${KERNELORG_MIRROR}/linux/daemons/autofs/v4/${BP}-misc-fixes.patch;name=patch1 \
           ${KERNELORG_MIRROR}/linux/daemons/autofs/v4/${BP}-multi-parse-fix.patch;name=patch2 \
           ${KERNELORG_MIRROR}/linux/daemons/autofs/v4/${BP}-non-replicated-ping.patch;name=patch3 \
           file://cross.patch \
           file://Makefile.rules-cross.patch \
           file://install.patch \
           file://auto.net-sort-option-fix.patch \
           file://autofs-additional-distros.patch \
           file://no-bash.patch \
           file://auto.hotplug \
           file://auto.master \
           file://auto.network \
           file://autofs \
           file://volatiles.99_autofs \
"
SRC_URI[archive.md5sum] = "7e3949114c00665b4636f0c318179657"
SRC_URI[archive.sha256sum] = "e25caa0e9639ea54dd7c4f21e8146ac9859a61fa126f397edf874b5fdc147430"
SRC_URI[patch1.md5sum] = "6342d6908c35af72b29231ecc6a10b5a"
SRC_URI[patch1.sha256sum] = "4fc5725c683405e0da29021aacb3674c71ce1b61f62b810430aa112644773cf8"
SRC_URI[patch2.md5sum] = "2783f4498c7e90a2cbf93b44d4fc4b94"
SRC_URI[patch2.sha256sum] = "91d852ae612b19862d3925a807c319c74a0a06cc7a8f7390715591b6e1110108"
SRC_URI[patch3.md5sum] = "b7d81c9aa92884d55ce5a1075d49fe78"
SRC_URI[patch3.sha256sum] = "398c921161a57f1d87a5829ea264deed9e2f3adc64ac011f7f0490257d31b633"

S = "${WORKDIR}/${BP}"

inherit autotools update-rc.d

EXTRA_OEMAKE = "STRIP=true RANLIB=${RANLIB}"

do_configure_prepend () {
        if [ ! -e acinclude.m4 ]; then
                cp aclocal.m4 acinclude.m4
        fi
}
do_install () {
        install -d ${D}${mandir}/man5 ${D}${mandir}/man8 ${D}${sbindir}
        oe_runmake 'INSTALLROOT=${D}' install
        install -d ${D}${sysconfdir}/init.d
        install ${WORKDIR}/autofs ${D}${sysconfdir}/init.d
        install ${WORKDIR}/auto.hotplug ${D}${sysconfdir}/auto.hotplug
        install ${WORKDIR}/auto.master ${D}${sysconfdir}/auto.master
        install ${WORKDIR}/auto.network ${D}${sysconfdir}/auto.network
        install -d ${D}${sysconfdir}/default/volatiles
        install -m 644 ${WORKDIR}/volatiles.99_autofs ${D}${sysconfdir}/default/volatiles/99_autofs
}

# FIXME: modules/Makefile has crappy rules that don't obey LDFLAGS
CFLAGS += "${LDFLAGS}"

INITSCRIPT_NAME = "autofs"
INITSCRIPT_PARAMS = "defaults"

PARALLEL_MAKE = ""

INSANE_SKIP_${PN} = "dev-so"
