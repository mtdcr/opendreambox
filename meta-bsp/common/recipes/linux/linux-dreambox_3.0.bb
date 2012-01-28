PR = "${INC_PR}.1"

PATCHREV = "07be7f68d42eb6681d7329bef00f305631385d37"
PATCHLEVEL = "18"

SRC_URI = " \
        ${KERNELORG_MIRROR}/pub/linux/kernel/v3.0/linux-3.0.tar.bz2;name=kernel \
        ${KERNELORG_MIRROR}/pub/linux/kernel/v3.0/patch-3.0.${PATCHLEVEL}.bz2;apply=yes;name=kernel-patch \
        http://sources.dreamboxupdate.com/download/kernel-patches/${P}-${PATCHREV}.patch.bz2;name=dmm-patch \
        file://clear_sublevel.patch \
        file://fadvise_dontneed_change.patch \
        file://fix-proc-cputype.patch \
        file://defconfig \
"

SRC_URI[kernel.md5sum] = "398e95866794def22b12dfbc15ce89c0"
SRC_URI[kernel.sha256sum] = "64b0228b54ce39b0b2df086109a7b737cde58e3df4f779506ddcaccee90356a0"
SRC_URI[kernel-patch.md5sum] = "3508052ae2d9799b78fae05895909279"
SRC_URI[kernel-patch.sha256sum] = "070af24e9b7375040d2a373b44c474fc91c01176fd5e33b33f84885590c9133f"
SRC_URI[dmm-patch.md5sum] = "75e51ab333889669d72440577351ed46"
SRC_URI[dmm-patch.sha256sum] = "9a9d3582e6c2a42ec40653b4206f30d3893486b4caa1cdfe20a779f65f9a50b9"

S = "${WORKDIR}/linux-3.0"

require linux-dreambox.inc
