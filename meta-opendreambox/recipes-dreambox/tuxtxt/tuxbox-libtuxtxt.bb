DESCRIPTION = "tuxbox libtuxtxt"
LICENSE = "Proprietary"
DEPENDS = "dreambox-dvbincludes libpng freetype"
SRCDATE = "20090130"
PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/libs;method=ext \
        file://acinclude.m4 \
        file://ignorelibs.patch \
        file://32bpp.diff \
        file://resize_framebuffer.diff \
        file://allow_different_demux.diff \
"

S = "${WORKDIR}/libs"

inherit autotools pkgconfig

do_configure_prepend() {
        install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
        sed -i -e s:@LIBTUXBOX_LIBS@::g ${S}/libtuxtxt/tuxbox-tuxtxt.pc.in
}

CPPFLAGS += "-DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
