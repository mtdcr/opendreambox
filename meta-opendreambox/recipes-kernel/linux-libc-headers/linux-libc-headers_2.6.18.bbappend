PR .= "-dream0"

SRC_URI_append_opendreambox = " \
	file://mips-add-missing-headers.patch \
	file://mips-fix-ptrace-header.patch \
	file://mips-brcm-add-missing-syscalls.patch \
	file://dvb-api-2.6.18-5.3.patch \
"
