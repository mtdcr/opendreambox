PR = "${INC_PR}.0"

PATCHREV = "a3eaf43fbd1c2994fb61fd7065724ff4f2e4f1e0"
PATCHLEVEL = "2"

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
SRC_URI[kernel-patch.md5sum] = "e9e53fba37c5e2afa4cdecab234120bd"
SRC_URI[kernel-patch.sha256sum] = "07f4e78a4e5107ecf55e44030ddd3b177c18fc6cc9458657e9763946c9c94c0c"
SRC_URI[dmm-patch.md5sum] = "29e0428508845663144ea8ed26575054"
SRC_URI[dmm-patch.sha256sum] = "a725831642a8d19a9664592adf36ab7a1341cca0a3570f1c02e5e449cbf2738f"

S = "${WORKDIR}/linux-3.2"

require linux-dreambox.inc