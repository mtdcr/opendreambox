DESCRIPTION = "Dreambox watchdog to automatically restart binaries"
PR = "r1"

inherit opendreambox-precompiled-binary

SRC_URI[mipsel.md5sum] = "d11eac1867b6e7651e3d6545e1a53289"
SRC_URI[mipsel.sha256sum] = "a16906b210329a449aa76f897658a0413fffb79f968b618144bd6972ea6c6723"
SRC_URI[mipsel-nofp.md5sum] = "97b3e858686bbab98968427177af2d30"
SRC_URI[mipsel-nofp.sha256sum] = "ad31358845dbc4fd684db9344e41e40e92094c0f1715091848f735d2fec85fb9"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 wdog ${D}${bindir}
}
