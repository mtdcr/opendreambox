PR = "${INC_PR}.0"

PATCHREV = "07be7f68d42eb6681d7329bef00f305631385d37"

SRC_URI = " \
        ${KERNELORG_MIRROR}/pub/linux/kernel/v3.0/linux-3.0.17.tar.bz2;name=kernel \
        http://sources.dreamboxupdate.com/download/kernel-patches/${P}-${PATCHREV}.patch.bz2;name=patch \
        file://clear_sublevel.patch \
        file://fadvise_dontneed_change.patch \
        file://fix-proc-cputype.patch \
        file://defconfig \
"

SRC_URI[kernel.md5sum] = "fcdd6a945445336e4cd28b2d195f1fea"
SRC_URI[kernel.sha256sum] = "20d5b93278515520fd8f28cf94f23a82610c05bb86f5ae5a054393415c1ca28c"
SRC_URI[patch.md5sum] = "75e51ab333889669d72440577351ed46"
SRC_URI[patch.sha256sum] = "9a9d3582e6c2a42ec40653b4206f30d3893486b4caa1cdfe20a779f65f9a50b9"

S = "${WORKDIR}/linux-3.0.17"

require linux-dreambox.inc
