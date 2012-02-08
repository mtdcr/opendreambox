DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
RDEPENDS_${PN} = "wdog"
PR = "r2"

inherit opendreambox-precompiled-binary opendreambox-sysvinit

SRC_URI += " \
        file://dccamd.sysvinit \
"
SRC_URI[mipsel.md5sum] = "162282fa2c8de55693d6a2497d4632bf"
SRC_URI[mipsel.sha256sum] = "123d8a284fa6b2caff8369f80040ef04f9852bbfe5837aca7b625c564ea5a867"
SRC_URI[mipsel-nofp.md5sum] = "44994543d4269c67a0cd07b79a74e582"
SRC_URI[mipsel-nofp.sha256sum] = "36174fc8d548b222b1279c385ff03d9546ece9381307ee26c6511a63b3702fc1"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 dccamd ${D}${bindir}
}
