PR = "${INC_PR}.0"

SRC_URI = "file://small_hdd_bugfix.patch \
           file://fix_madwifi.patch \
           file://enigma2_de.mo"
SRC_URI[mipsel.md5sum] = "4247aa0ae4e3a8e16b2a3fb3c3eedd2c"
SRC_URI[mipsel.sha256sum] = "a6aadabfb2276f6dad754b13644e89f674853c21428ddfcb67c5922d1168417f"
SRC_URI[mipsel-nf.md5sum] = "fb8197fa34fa5d97c1b000e3307db8a6"
SRC_URI[mipsel-nf.sha256sum] = "38961ef13bda35a22e379fef84de0e1e20d968b91696e2a1747452bcaf3912a1"

do_install_append(){
        cp ${WORKDIR}/enigma2_de.mo ${D}/usr/share/enigma2/po/de/LC_MESSAGES/enigma2.mo
}

require enigma2-bin-3.2.inc
