# dreambox-mipsel.inc

DREAMBOX_KERNEL_VERSION ?= "2.6.18"

MACHINE_FEATURES += "alsa"

OLDEST_KERNEL = "2.6.18"

PREFERRED_PROVIDER_task-opendreambox-dvbapi = "task-opendreambox-dvbapi3"
PREFERRED_PROVIDER_task-opendreambox-ui = "task-opendreambox-enigma2"

TARGET_ARCH = "mipsel"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc
