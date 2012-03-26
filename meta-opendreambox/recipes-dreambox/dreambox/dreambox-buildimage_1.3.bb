DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://src/buildimage.c;endline=17;md5=ea8d8cabec86117939480a328ac3a34b"
PR = "r0"

SRCREV = "9f88f899b625231c126d2514bd53e98665a52f04"

inherit autotools opendreambox-git

BBCLASSEXTEND = "native"

OPENDREAMBOX_PROJECT = "buildimage"
