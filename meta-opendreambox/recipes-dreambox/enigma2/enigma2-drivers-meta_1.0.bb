DESCRIPTION = "Descriptions for driver packages used by enigma2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=861a56d19a6e100979e4c596ed785160"

SRC_URI = " \
        file://genmetaindex.py \
        file://driver_r8712u.xml \
        file://driver_rt3070.xml \
"

S = "${WORKDIR}"

inherit allarch

do_install() {
        install -d ${D}${datadir}/meta
        install ${S}/*.xml ${D}${datadir}/meta
        for f in *.xml; do
                python ${WORKDIR}/genmetaindex.py ${D}${datadir}/meta/driver_*.xml > ${D}${datadir}/meta/index-enigma2-drivers.xml
        done
}

FILES_${PN} = "${datadir}/meta"
