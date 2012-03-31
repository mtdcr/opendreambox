PR = "${INC_PR}.1"

SRC_URI = "file://small_hdd_bugfix.patch \
           file://fix_madwifi.patch \
           file://enigma2_de.mo"

do_install_append(){
        cp ${WORKDIR}/enigma2_de.mo ${D}/usr/share/enigma2/po/de/LC_MESSAGES/enigma2.mo
}

SRC_URI[dm500hd.md5sum] = "892030d9b1c32666300ff2ff50c29eb0"
SRC_URI[dm500hd.sha256sum] = "e3bc1681e25350f3d1ae29855ca2907fe1b3e422e335fd471fe0c49ab27b61f3"
SRC_URI[dm7020hd.md5sum] = "dbe65bf10c4139cc456c20628ae8a46d"
SRC_URI[dm7020hd.sha256sum] = "fe10b48d64a66267bae00bba6fa8eb6749eefba0103ab2a7ac91180acb28d264"
SRC_URI[dm800.md5sum] = "6a7e2cb7d2b521ac6b4ada74176c836c"
SRC_URI[dm800.sha256sum] = "25c26dc16f2877dda75375149b4cbb3cad7305c55e9df03cc1c806ea2c1e3486"
SRC_URI[dm8000.md5sum] = "458b81b1344e5780056ea22dd51f3f83"
SRC_URI[dm8000.sha256sum] = "2c54af45d823bfbf140ff3a1ebb6b4d8f39bb6f062b829fb4cfbc7df2a1238f7"
SRC_URI[dm800se.md5sum] = "2fe6aaf81b7d8ff00140643f67beb415"
SRC_URI[dm800se.sha256sum] = "955069b19ab178b51da516fa1570135e27e2f90ac0928fabec72443f24ae7438"

require enigma2-bin-3.2.inc
