DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
LICENSE = "Proprietary"

SRCREV = "${AUTOREV}"
SCHWERKRAFT_PROJECT = "streamproxy"

INETD_SERVICE_NAME = "8001"
INETD_PROGRAM = "${bindir}/streamproxy"

inherit autotools inetd schwerkraft-git
