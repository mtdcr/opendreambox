DESCRIPTION = "lightweight, efficient FTP server written for security"
HOMEPAGE = "http://vsftpd.beasts.org/"
SECTION = "console/network"
LICENSE = "GPLv2 with OpenSSL Exception"
DEPENDS = "libcap openssl"
DEPENDS += "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"
PR = "r1"

SRC_URI = " \
        https://security.appspot.com/downloads/${BPN}-${PV}.tar.gz \
        file://01-builddefs.patch \
        file://02-config.patch \
        file://03-db-doc.patch \
        file://04-link-local.patch \
        file://05-whitespaces.patch \
        file://06-greedy.patch \
        file://07-utf8.patch \
        file://08-manpage.patch \
        file://09-s390.patch \
        file://10-remote-dos.patch \
"
SRC_URI[md5sum] = "2ea5d19978710527bb7444d93b67767a"
SRC_URI[sha256sum] = "b466edf96437afa2b2bea6981d4ab8b0204b83ca0a2ac94bef6b62b42cc71a5a"

S = "${WORKDIR}/${BPN}-${PV}"

INETD_SERVICE_NAME = "ftp"

inherit inetd

CFLAGS = "${TARGET_CFLAGS}"
CFLAGS += "-DVSF_BUILD_SSL=1"
CFLAGS += "${@base_contains('DISTRO_FEATURES', 'pam', '-DVSF_BUILD_PAM=1', '', d)}"

LIBS = "-lcap -lcrypt -lssl -lcrypto"
LIBS += "${@base_contains('DISTRO_FEATURES', 'pam', '-lpam', '', d)}"

LINK = "${TARGET_LDFLAGS}"

SECURE_CHROOT_DIR = "${datadir}/${PN}/chroot"
RSA_CERT_FILE = "${sysconfdir}/ssl/private/${PN}.pem"

do_patchpost() {
        rm -f builddefs.h
        touch builddefs.h
}
do_configure() {
        set_default() {
                NAME=$1
                VALUE=$2
                sed -e "s,^#\?${NAME}=.*,${NAME}=${VALUE}," -i vsftpd.conf
        }
        set_default listen NO
        set_default listen_ipv6 NO
        set_default anonymous_enable NO
        set_default local_enable YES
        set_default write_enable YES
        set_default anon_upload_enable NO
        set_default anon_mkdir_write_enable NO
        set_default dirmessage_enable NO
        set_default use_localtime YES
        set_default xferlog_enable NO
        set_default connect_from_port_20 YES
        set_default chown_uploads NO
        set_default nopriv_user vsftpd
        set_default async_abor_enable YES
        set_default ascii_upload_enable NO
        set_default ascii_download_enable NO
        set_default ftpd_banner "Welcome to the ${DISTRO_NAME} FTP service!"
        set_default chroot_local_user NO
        set_default chroot_list_enable NO
        set_default ls_recurse_enable YES
        set_default secure_chroot_dir "${SECURE_CHROOT_DIR}"
        set_default rsa_cert_file "${RSA_CERT_FILE}"
}
do_compile() {
        oe_runmake 'CFLAGS=${CFLAGS}' 'LIBS=${LIBS}' 'LINK=${LINK}'
}
do_install() {
        install -d ${D}${sysconfdir}
        install -m 644 vsftpd.conf ${D}${sysconfdir}
        install -d ${D}${sbindir}
        install -m 755 vsftpd ${D}${sbindir}/vsftpd
        install -d ${D}${mandir}/man8
        install -m 644 vsftpd.8 ${D}${mandir}/man8/vsftpd.8
        install -d ${D}${mandir}/man5
        install -m 644 vsftpd.conf.5 ${D}${mandir}/man5/vsftpd.conf.5
        install -d ${D}${SECURE_CHROOT_DIR}
}

addtask patchpost after do_patch before do_configure

pkg_postinst_${PN}() {
if [ "x$D" != "x" ]; then
        exit 1
fi
addgroup -S vsftpd
adduser -S -h ${SECURE_CHROOT_DIR} -H -G vsftpd -D -s /bin/false vsftpd
}
pkg_postrm_${PN}() {
if [ "x$D" != "x" ]; then
        exit 1
fi
deluser vsftpd
}
