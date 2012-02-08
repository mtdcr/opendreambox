EXTRA_IMAGECMD_jffs2 = "-e ${DREAMBOX_ERASE_BLOCK_SIZE} -n -l"
IMAGE_CMD_jffs2 = " \
	mkfs.jffs2 \
		--root=${IMAGE_ROOTFS}/boot \
		--faketime \
		--disable-compressor=lzo \
		--compression-mode=size \
		--output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		${EXTRA_IMAGECMD}; \
	rm -rf ${IMAGE_ROOTFS}/boot/*; \
	printf '/dev/mtdblock2\t/boot\t\tjffs2\tro\t\t\t\t0 0\n' >> ${IMAGE_ROOTFS}/etc/fstab; \
	mkfs.jffs2 \
		--root=${IMAGE_ROOTFS} \
		--faketime \
		--disable-compressor=lzo \
		--compression-mode=size \
		--output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		${EXTRA_IMAGECMD}; \
	buildimage \
		--arch ${MACHINE} \
		${EXTRA_BUILDCMD} \
		--erase-block-size ${DREAMBOX_ERASE_BLOCK_SIZE} \
		--flash-size ${DREAMBOX_FLASH_SIZE} \
		--sector-size ${DREAMBOX_SECTOR_SIZE} \
		--boot-partition ${DREAMBOX_PART0_SIZE}:${STAGING_DATADIR}/dreambox-secondstage/secondstage-${MACHINE}.bin \
		--data-partition ${DREAMBOX_PART1_SIZE}:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		--data-partition ${DREAMBOX_PART2_SIZE}:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi; \
"
