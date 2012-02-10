DESCRIPTION = "DVB / MPEG stream analyzer"
LICENSE = "Proprietary"
AUTHOR = "Rainer Scherg <rasc@users.sourceforge.net>"
SRCDATE = "20081001"
PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/dvbsnoop;method=ext"

S = "${WORKDIR}/dvbsnoop"

inherit autotools pkgconfig
