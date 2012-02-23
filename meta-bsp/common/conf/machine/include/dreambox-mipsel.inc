# dreambox-mipsel.inc

DREAMBOX_KERNEL_VERSION = "3.2"
LINUXLIBCVERSION = "3.1"
OLDEST_KERNEL = "3.1"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc
