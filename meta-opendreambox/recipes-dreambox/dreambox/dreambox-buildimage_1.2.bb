DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://src/buildimage.c;endline=17;md5=ea8d8cabec86117939480a328ac3a34b"
PR = "r1"

SRCREV = "c208f6d5b1fe92de060a94bf327b0d897e64ba93"

inherit autotools opendreambox-git

BBCLASSEXTEND = "native"

OPENDREAMBOX_PROJECT = "buildimage"
