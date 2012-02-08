DESCRIPTION = "file system client for mounting network media servers"
HOMEPAGE = "http://djmount.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "fuse libupnp"

SRC_URI = " \
        ${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
        file://filebuffer-fix_range.patch \
        file://djmount.init \
"
SRC_URI[md5sum] = "c922753e706c194bf82a8b6ca77e6a9a"
SRC_URI[sha256sum] = "aa5bb482af4cbd42695a7e396043d47b53d075ac2f6aa18a8f8e11383c030e4f"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-external-libupnp"

do_configure() {
        oe_runconf
}
do_install_append() {
        install -d ${D}/${INIT_D_DIR}
        install -m 0755 ${WORKDIR}/djmount.init ${D}/${INIT_D_DIR}/djmount
}

INITSCRIPT_NAME = "djmount"
