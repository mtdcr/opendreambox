require blindscan-utils.inc

PR = "${INC_PR}.0"

SRC_URI[mipsel.md5sum] = "0707c05dee226010ab199652b9f69c76"
SRC_URI[mipsel.sha256sum] = "8469f55063f175ea21ac66902d2ad2f40635721ae5a9ac6b48ba9d62cb2ff43f"
SRC_URI[mipsel-nf.md5sum] = "eb157db6f17fcd6c6c5094e04ee1a105"
SRC_URI[mipsel-nf.sha256sum] = "2ec00e4b477a7896aa4a0e252dcad6abb5b5d4a60f35e1f0b5688a22ab0c32e6"

inherit opendreambox-precompiled-binary

do_install() {
        install -d ${D}${bindir}
        install -m 0755 * ${D}${bindir}
}
