require busybox_1.1x.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://fix-iptunnel-location.patch \
	"

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "c3938e1ac59602387009bbf1dd1af7f6"
SRC_URI[sha256sum] = "a1a9a35732c719ef384f02b6e357c324d8be25bc154af91a48c4264b1e6038f0"
