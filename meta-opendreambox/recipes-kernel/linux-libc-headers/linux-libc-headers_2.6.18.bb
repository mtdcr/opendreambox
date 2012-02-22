require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR = "r1"

SRC_URI += " \
        file://mips-add-missing-headers.patch \
        file://mips-fix-ptrace-header.patch \
        file://mips-brcm-add-missing-syscalls.patch \
        file://dvb-api-2.6.18-5.3.patch \
        file://fix-linux-futex-h.patch \
"
SRC_URI[md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"
