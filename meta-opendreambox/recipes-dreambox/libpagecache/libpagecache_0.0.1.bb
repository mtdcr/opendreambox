DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"
LICENSE = "CLOSED"
SRCREV = "${AUTOREV}"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "${libdir}/libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
