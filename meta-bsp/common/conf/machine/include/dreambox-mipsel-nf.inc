# dreambox-mipsel-nf.inc

DREAMBOX_KERNEL_VERSION = "2.6.18"
LINUXLIBCVERSION = "2.6.18"
OLDEST_KERNEL = "2.6.18"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mipsel-nf"

require conf/machine/include/dreambox.inc
require conf/machine/include/mips/arch-mips.inc
