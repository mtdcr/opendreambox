DESCRIPTION = "open source C++ wrapper library for SQLite"
HOMEPAGE = "http://sqlitewrapper.kompex-online.com/"
LICENSE = "LGPLv3+"

SRC_URI = " \
        http://sqlitewrapper.kompex-online.com/counter/download.php?dl=KompexSQLiteWrapper-Source_${PV}.tar.gz \
        file://add_automake.patch \
"
SRC_URI[md5sum] = "117a2562d0a904d770d6db55fb079ba2"
SRC_URI[sha256sum] = "72751327aa7be469c10492339147350d9d6a08010587bb44f218f37a1775320b"

S = "${WORKDIR}/KompexSQLiteWrapper-Source_${PV}"

inherit autotools pkgconfig
