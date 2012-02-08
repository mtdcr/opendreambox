DESCRIPTION = "Descriptions for driver packages used by enigma2"
LICENSE = "proprietary"

SRC_URI = " \
        file://genmetaindex.py \
        file://driver_r8712u.xml \
        file://driver_rt3070.xml \
"

S = "${WORKDIR}"

do_install() {
        install -d ${D}${datadir}/meta
        install ${S}/*.xml ${D}${datadir}/meta
        for f in *.xml; do
                python ${WORKDIR}/genmetaindex.py ${D}${datadir}/meta/driver_*.xml > ${D}${datadir}/meta/index-enigma2-drivers.xml
        done
}

PACKAGE_ARCH = "all"

FILES_${PN} = "${datadir}/meta"
