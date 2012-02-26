DEPENDS = ""

SRC_URI = "http://dreamboxupdate.com/download/snapshots/enigma2_${PV}_${MACHINE}.tar.bz2;name=${PACKAGE_ARCH}"
SRC_URI[dm500hd.md5sum] = "f549dbbd92f4bf2feb5daa57c43bacdb"
SRC_URI[dm500hd.sha256sum] = "e604be4c8b9556f193771c836409fb18830a18a8ba88ed534a3e52aae24132e7"
SRC_URI[dm7020hd.md5sum] = "10319798762789bc98c21f990f5dbfe8"
SRC_URI[dm7020hd.sha256sum] = "a6a39ad3a3e64a2d6fbebf7b460dc9f9792bd2cd0afb93c86d962c0aa7790e4b"
SRC_URI[dm800.md5sum] = "eca56154b9fa8737cda51ed1e1b01152"
SRC_URI[dm800.sha256sum] = "3a47cba870cf3d9100acff349443dc467957dea3113b23178791d49ee420cf8e"
SRC_URI[dm8000.md5sum] = "0ff418ce087bdc4d2799e235e1f4e8ac"
SRC_URI[dm8000.sha256sum] = "553dc5364ec2eb68315557c34c3da585d5e66f3ff9f6608a87a337c4b2df62ca"
SRC_URI[dm800se.md5sum] = "f6b802c5bf41992466b2be8ed64da8e0"
SRC_URI[dm800se.sha256sum] = "460ebcd228ef34f6f60e6a3872933c550ecce3220ea395909c73fad447719285"

S = "${WORKDIR}/enigma2_${PV}_${MACHINE}"

do_compile() {
}
do_install() {
        cp -R usr ${D}/
}

require enigma2-common.inc
