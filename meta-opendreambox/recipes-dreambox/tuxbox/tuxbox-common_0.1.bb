DESCRIPTION = "Tuxbox common files"
LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"

inherit opendreambox-git

do_install() {
        install -d ${D}${sysconfdir}
        install -d ${D}${sysconfdir}/tuxbox
        install -m 0644 timezone.xml ${D}${sysconfdir}
        install -m 0644 satellites.xml ${D}${sysconfdir}/tuxbox
        install -m 0644 terrestrial.xml ${D}${sysconfdir}/tuxbox
}

FILES_${PN} = "${sysconfdir}"

OPENDREAMBOX_PROJECT = "obi/enigma2-xml-data"
