PR = "${INC_PR}.0"

SRC_URI = "file://small_hdd_bugfix.patch \
           file://fix_madwifi.patch \
           file://enigma2_de.mo"
SRC_URI[mipsel.md5sum] = "dbe65bf10c4139cc456c20628ae8a46d"
SRC_URI[mipsel.sha256sum] = "fe10b48d64a66267bae00bba6fa8eb6749eefba0103ab2a7ac91180acb28d264"
SRC_URI[mipsel-nf.md5sum] = "6a7e2cb7d2b521ac6b4ada74176c836c"
SRC_URI[mipsel-nf.sha256sum] = "25c26dc16f2877dda75375149b4cbb3cad7305c55e9df03cc1c806ea2c1e3486"

do_install_append(){
        cp ${WORKDIR}/enigma2_de.mo ${D}/usr/share/enigma2/po/de/LC_MESSAGES/enigma2.mo
}

require enigma2-bin-3.2.inc
