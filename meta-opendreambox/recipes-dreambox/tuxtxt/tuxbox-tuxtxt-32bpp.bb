DESCRIPTION = "tuxbox tuxtxt for 32bit framebuffer"
LICENSE = "Proprietary"
DEPENDS = "freetype tuxbox-libtuxtxt"
RDEPENDS_${PN} = "enigma2"
SRCDATE = "20090130"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxtxt;method=ext \
        file://makefiles.diff \
        file://nonblocking.diff \
        file://32bpp.diff \
        file://add_new_default_conf.diff \
        file://add_advanced_rc.diff \
        file://allow_different_demux.diff \
        file://plugin.py"

S = "${WORKDIR}/tuxtxt"

inherit autotools pkgconfig

do_configure_prepend() {
        touch ${S}/python/__init__.py
        install -m 0644 ${WORKDIR}/plugin.py ${S}/python
}

FILES_${PN} += "${datadir}/fonts/tuxtxt.otb ${libdir}/enigma2 /etc/tuxtxt"

CPPFLAGS += "-DHAVE_DREAMBOX_HARDWARE -DDREAMBOX -I${STAGING_INCDIR}/tuxbox/tuxtxt"
