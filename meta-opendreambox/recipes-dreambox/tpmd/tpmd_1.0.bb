DESCRIPTION = "Dreambox TPM Daemon"
RDEPENDS_${PN} = "wdog"
PR = "r2"

inherit opendreambox-precompiled-binary opendreambox-sysvinit

SRC_URI += " \
        file://tpmd.sysvinit \
"
SRC_URI[mipsel.md5sum] = "3190a57f86019f1ab6605ab01dacff88"
SRC_URI[mipsel.sha256sum] = "79e080f6f90ec00dd456a76595ed4e6029217f5a9e25723b0d03be3ab9554cd9"
SRC_URI[mipsel-nf.md5sum] = "f55072d0ab39fe398e6b8a781baa561f"
SRC_URI[mipsel-nf.sha256sum] = "1c379684d885f6f68b2c246f30c3a19ebe144e6f9ad472f80d5c7db8a73b67d3"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 tpmd ${D}${bindir}
}
