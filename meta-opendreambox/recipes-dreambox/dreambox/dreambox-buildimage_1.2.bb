DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r1"

SRCREV = "c208f6d5b1fe92de060a94bf327b0d897e64ba93"

inherit autotools opendreambox-git

BBCLASSEXTEND = "native"

OPENDREAMBOX_PROJECT = "buildimage"
