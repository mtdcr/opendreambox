SUMMARY = "A Dreambox firmware image"

# packages to build for the feed
DEPENDS = " \
	gdb \
	lsof \
	ltrace \
	strace \
"

# packages to drag into the image
IMAGE_INSTALL = " \
	task-core-boot ${ROOTFS_PKGMANAGE} \
	task-opendreambox-base \
	task-opendreambox-dvbapi3 \
	task-opendreambox-enigma2 \
"

# enable online package management
IMAGE_FEATURES += "package-management"

# we don't want any locales, at least not in the common way.
IMAGE_LINGUAS = ""

inherit image

opendreambox_rootfs_postprocess() {
    # generate /etc/image-version
    IMAGE_DATE=`date +%Y%m%d%H%M`
    # 0: Release, 1: Experimental
    IMAGE_TYPE="1"
    # e.g. 400 for release 4.0.0, if IMAGE_TYPE=0
    IMAGE_VERSION="000"
    echo "version=${IMAGE_TYPE}${IMAGE_VERSION}${IMAGE_DATE}" > ${IMAGE_ROOTFS}/etc/image-version
}

ROOTFS_POSTPROCESS_COMMAND += "opendreambox_rootfs_postprocess; "