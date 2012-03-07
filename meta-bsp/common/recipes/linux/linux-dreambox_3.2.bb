PR = "${INC_PR}.2"

PATCHREV = "a3eaf43fbd1c2994fb61fd7065724ff4f2e4f1e0"
PATCHLEVEL = "9"

SRC_URI = " \
        ${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-3.2.tar.bz2;name=kernel \
        ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-3.2.${PATCHLEVEL}.bz2;apply=yes;name=kernel-patch \
        http://sources.dreamboxupdate.com/download/kernel-patches/${P}-${PATCHREV}.patch.bz2;name=dmm-patch \
        file://clear_sublevel.patch \
        file://fadvise_dontneed_change.patch \
        file://fix-proc-cputype.patch \
        file://no-force-threaded-interrupts.patch \
        file://brcmnand-buildfix.patch \
        file://brcmnand-fixed-corr-uncorr-error-detection.patch \
        file://defconfig \
"

SRC_URI[kernel.md5sum] = "7ceb61f87c097fc17509844b71268935"
SRC_URI[kernel.sha256sum] = "c881fc2b53cf0da7ca4538aa44623a7de043a41f76fd5d0f51a31f6ed699d463"
SRC_URI[kernel-patch.md5sum] = "4610f3e62a5446422d1e81a90ab3cd06"
SRC_URI[kernel-patch.sha256sum] = "7836685dee161a4ffaf887b8e2f8dd3cb7712e690d0942fefb1db09bb6ad3871"
SRC_URI[dmm-patch.md5sum] = "29e0428508845663144ea8ed26575054"
SRC_URI[dmm-patch.sha256sum] = "a725831642a8d19a9664592adf36ab7a1341cca0a3570f1c02e5e449cbf2738f"

S = "${WORKDIR}/linux-3.2"

require linux-dreambox.inc
