#
# - If MIPS_ARCH is the name of a MIPS ISA, i.e. it starts with "mips",
#   then use just TARGET_ARCH. Otherwise it is a processor name and will
#   be appended to it.
# - Append '-nofp' for soft-float.
#
# examples: MIPS_ARCH=4kc TARGET_ARCH=mipsel TARGET_FPU=hard -> mipsel-4kc
#           MIPS_ARCH=4kc TARGET_ARCH=mips TARGET_FPU=soft -> mips-4kc-nofp
#           MIPS_ARCH=mips32 TARGET_ARCH=mipsel TARGET_FPU=soft -> mipsel-nofp
#           MIPS_ARCH=mips64 TARGET_ARCH=mips64 TARGET_FPU=hard -> mips64
#           MIPS_ARCH=mips64 TARGET_ARCH=mips64el TARGET_FPU=hard -> mips64el
#

MIPS_CPU_SUFFIX = "${@['-${MIPS_ARCH}', ''][bb.data.getVar('MIPS_ARCH', d, 1).startswith('mips')]}"
MIPS_FP_SUFFIX = "${@['', '-nofp'][bb.data.getVar('TARGET_FPU', d, 1) == 'soft']}"
MIPS_FP_OPT = "${@['-mhard-float', '-msoft-float'][bb.data.getVar('TARGET_FPU', d, 1) == 'soft']}"
MIPS_PACKAGE_ARCH = "${TARGET_ARCH}${MIPS_CPU_SUFFIX}${MIPS_FP_SUFFIX}"

TARGET_CC_ARCH = "-march=${MIPS_ARCH} ${MIPS_FP_OPT}"

FEED_ARCH = "${MIPS_PACKAGE_ARCH}"
BASE_PACKAGE_ARCH = "${MIPS_PACKAGE_ARCH}"
PACKAGE_EXTRA_ARCHS += "${@['${MIPS_PACKAGE_ARCH}', ''][bb.data.getVar('TARGET_ARCH', d, 1) == '${MIPS_PACKAGE_ARCH}']}"
