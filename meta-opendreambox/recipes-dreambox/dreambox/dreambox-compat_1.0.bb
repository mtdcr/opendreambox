DESCRIPTION = "Dreambox compatibility links"
SECTION = "base"
PRIORITY = "required"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"

inherit allarch

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
