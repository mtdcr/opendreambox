require recipes-connectivity/openssl/openssl.inc

PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=f9a8f968107345e0b75aa8c2ecaa7ec8"

SRC_URI += "file://debian/ca.patch \
            file://debian/config-hurd.patch;apply=no \
            file://debian/debian-targets.patch \
            file://debian/engines-path.patch \
            file://debian/kfreebsd-pipe.patch;apply=no \
            file://debian/make-targets.patch \
            file://debian/man-dir.patch \
            file://debian/man-section.patch \
            file://debian/no-rpath.patch \
            file://debian/no-symbolic.patch \
            file://debian/pic.patch \
            file://debian/pkg-config.patch \
            file://debian/rc4-amd64.patch \
            file://debian/rehash-crt.patch \
            file://debian/rehash_pod.patch \
            file://debian/shared-lib-ext.patch \
            file://debian/stddef.patch \
            file://debian/version-script.patch \
            file://debian/perl-path.diff"

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://parallel-make-fix.patch"

SRC_URI[md5sum] = "f5dabb7ffb068eecf245f1b2151df100"
SRC_URI[sha256sum] = "6b9b3ef5ea942d7b5c3ce23e9e929d8eecd090e81f18d87ad3aaf2eb9a226a14"

EXTRA_OECONF += "no-idea no-mdc2 no-rc5"

BBCLASSEXTEND = "native nativesdk"

PARALLEL_MAKEINST = ""
