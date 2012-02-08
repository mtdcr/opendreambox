DESCRIPTION = "Dreambox compatibility links"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

do_install() {
        install -d ${D}${base_libdir}
        ln -sf libgcc_s.so.1 ${D}${base_libdir}/libgcc_s_nof.so.1
        install -d ${D}${libdir}
        ln -sf libcrypto.so.1.0.0 ${D}${libdir}/libcrypto.so.0.9.7
        ln -sf libcrypto.so.1.0.0 ${D}${libdir}/libcrypto.so.0.9.8
        ln -sf libjpeg.so.8 ${D}${libdir}/libjpeg.so.62
        ln -sf libssl.so.1.0.0 ${D}${libdir}/libssl.so.0.9.7
        ln -sf libssl.so.1.0.0 ${D}${libdir}/libssl.so.0.9.8
}

PACKAGE_ARCH = "all"
