DESCRIPTION = "Handle & repair many DVB radio & television stream types."
LICENSE = "GPLv2"
SRCDATE = "20090824"

SRC_URI = "cvs://anonymous@project-x.cvs.sourceforge.net/cvsroot/project-x;module=Project-X;method=pserver \
           http://dreamboxupdate.com/download/opendreambox/${PN}-${TARGET_ARCH}-bin-20100218-${PV}-${DISTRO_VERSION}-${TARGET_FPU}.tar.bz2 \
           file://dreambox-headless.patch;striplevel=2 \
           file://Makefile"
SRC_URI[md5sum] = "2b53f925d0207b43b50fa98e5b304722"
SRC_URI[sha256sum] = "d033e2e56ccbeed57bc44fceb4b7f868abebf990bc0e08739bc3a034b3da891b"

S = "${WORKDIR}/Project-X/src"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/Makefile ${S}
        install -m 0755 ${WORKDIR}/projectx ${S}
}
do_compile() {
        export CROSS_COMPILE=${TARGET_PREFIX}
        export CROSS_LIBDIR="${CROSS_DIR}/${TARGET_SYS}/lib"
        export GCJ_ARCH=""
        export JFLAGS="-g0 -O2 -march=mips32 -encoding \"ISO-8859-1\""
        for gcjarchives in libgcj.a libgij.a; do
                if test -e ${CROSS_LIBDIR}/$gcjarchives; then
                        export GCJ_ARCHIVES="${GCJ_ARCHIVES} ${CROSS_LIBDIR}/$gcjarchives"
                fi
        done
        if [ -n "${GCJ_ARCHIVES}" ]; then
		rm -f projectx
                make projectx-static
        fi
}
do_install() {
        install -d ${D}${bindir}
        install -m 755 ${S}/projectx ${D}${bindir}
}
