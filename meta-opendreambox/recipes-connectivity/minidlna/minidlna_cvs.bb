DESCRIPTION = "lightweight DLNA/UPnP-AV server targeted at embedded systems"
HOMEPAGE = "http://sourceforge.net/projects/minidlna/"
SECTION = "network"
LICENSE = "GPLv2"
DEPENDS = "libexif jpeg libid3tag flac libvorbis sqlite3 libav util-linux-ng"
SRCDATE = "20120109"
PV = "1.0.22+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous@minidlna.cvs.sourceforge.net/cvsroot/minidlna;module=minidlna"

S = "${WORKDIR}/${PN}"

inherit autotools

EXTRA_AUTORECONF = ""

PACKAGES =+ "${PN}-utils"

FILES_${PN}-utils = "${bindir}/test*"
