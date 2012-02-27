DESCRIPTION = "Dreambox compatibility links"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"
DEPENDS = "openssl-0.9.8"
PRIORITY = "required"
PR = "r2"

inherit allarch

do_install() {
        install -d ${D}${base_libdir}
        ln -sf libcrypto.so.0.9.8 ${D}${base_libdir}/libcrypto.so.0.9.7
        ln -sf libgcc_s.so.1 ${D}${base_libdir}/libgcc_s_nof.so.1
        install -d ${D}${libdir}
        ln -sf libgif.so.4.1.6 ${D}${libdir}/libungif.so.4
        ln -sf libjpeg.so.8 ${D}${libdir}/libjpeg.so.62
        ln -sf libssl.so.0.9.8 ${D}${libdir}/libssl.so.0.9.7
}

RDEPENDS_${PN} = "libcrypto0.9.8"
