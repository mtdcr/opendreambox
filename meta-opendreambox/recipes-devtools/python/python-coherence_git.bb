DESCRIPTION = "Python UPnP framework"
HOMEPAGE = "http://coherence.beebits.net/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=3f7c147addd67ce1d53239c68a6b7022"
DEPENDS = "libxml2"
SRCREV = "67d5135e299a4ecefe8303a62e17b53edd21c896"
PV = "0.6.7"

SRC_URI = "git://github.com/htgoebel/coherence.git;protocol=git \
           file://fix-setup-py.patch"

S = "${WORKDIR}/git/Coherence"

inherit setuptools

do_configure_prepend() {
        sed -e 's,^from coherence import __version__$,__version__ = "${PV}",' -i setup.py
}
do_install_append() {
        rm ${D}${bindir}/applet-coherence
        rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/Coherence-${PV}-*.egg-info
        rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/coherence/test
        rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/misc/Desktop-Applet
}

PACKAGES =+ "${PN}-bin"

RDEPENDS_${PN}-bin = "${PN} python-xmlrpc python-zopeinterface"

FILES_${PN}-bin = "${bindir} ${PYTHON_SITEPACKAGES_DIR}/misc/*.py"
