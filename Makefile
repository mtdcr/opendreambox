#!/usr/bin/make -f
#
# Copyright (c) 2010-2012 Dream Multimedia GmbH, Germany
#                         http://www.dream-multimedia-tv.de/
# Authors:
#   Andreas Oberritter <obi@opendreambox.org>
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
#

# Note: You can override all variables by storing them
# in an external file called "build.conf".
-include build.conf

# Target platform:
# dm500hd, dm800, dm800se, dm7020hd, dm8000
#
# This only sets the default value. All platforms now use a shared build
# directory. Run "MACHINE=dm800se bitbake dreambox-image" to build an image
# for the dm800se, if it is not the default.
MACHINE ?= dm7020hd

# Adjust according to the number CPU cores to use for parallel build.
# Default: Number of processors in /proc/cpuinfo, if present, or 1.
NR_CPU := $(shell [ -f /proc/cpuinfo ] && grep -c '^processor\s*:' /proc/cpuinfo || echo 1)
BB_NUMBER_THREADS ?= $(NR_CPU)
PARALLEL_MAKE ?= -j $(NR_CPU)

# Remove work directories after successful builds
RM_WORK ?= yes

# Dependency generation algorithm: speed or completion.
BB_SCHEDULER ?= speed

PWD := $(shell pwd)

TOPDIR = $(PWD)/build/$(MACHINE)
DL_DIR = $(PWD)/sources
SSTATE_DIR = $(PWD)/sstate-cache
TMPDIR = $(PWD)/tmp

BBLAYERS = \
	$(PWD)/meta-bsp/$(MACHINE) \
	$(PWD)/meta-bsp/common \
	$(PWD)/meta-opendreambox \
	$(PWD)/meta-openembedded/meta-oe \
	$(PWD)/openembedded-core/meta

CONFFILES = \
	bitbake.env \
	compiler-mipsel.env \
	compiler-mipsel-nf.env \
	$(TOPDIR)/conf/bblayers.conf \
	$(TOPDIR)/conf/local.conf

GIT ?= git
GIT_REMOTE := $(shell $(GIT) remote)
GIT_USER_NAME := $(shell $(GIT) config user.name)
GIT_USER_EMAIL := $(shell $(GIT) config user.email)

.DEFAULT_GOAL := all
all: update usage

help:
	@echo "Your options:"
	@echo
	@echo "  * Build the PDF documentation (doc/opendreambox.pdf, requires pdfTeX):"
	@echo "      $$ make doc"
	@echo
	@echo "  * View the documentation in text format:"
	@echo "      $$ view doc/opendreambox.txt"
	@echo
	@echo "  * Select a new target machine:"
	@echo "      $$ echo MACHINE=dm800se >> build.conf"
	@echo "    [Valid values: dm500hd, dm800, dm800se, dm7020hd, dm8000]"
	@echo
	@echo "  * Build a firmware image for the selected target machine:"
	@echo "      $$ make image"
	@echo
	@echo "  * Build a firmware image for a different target machine:"
	@echo "      $$ make image MACHINE=dm800se"
	@echo "    [Valid values: dm500hd, dm800, dm800se, dm7020hd, dm8000]"
	@echo
	@echo "  * Download all source files at once:"
	@echo "      $$ make download"
	@echo
	@echo "  * Set up the environment to build recipes manually:"
	@echo "      $$ source bitbake.env"
	@echo "      $$ cd build/$(MACHINE)"
	@echo "      $$ bitbake <target>"
	@echo "    [Replace <target> with a recipe name, e.g. dreambox-image or enigma2]"
	@echo
	@echo "Your current settings:"
	@echo "  MACHINE = $(MACHINE)"
	@echo
	@echo "  BB_NUMBER_THREADS = $(BB_NUMBER_THREADS)"
	@echo "  BB_SCHEDULER = $(BB_SCHEDULER)"
	@echo "  PARALLEL_MAKE = $(PARALLEL_MAKE)"
	@echo "  RM_WORK = $(RM_WORK)"
	@echo
	@echo "Trouble finding a recipe? Try \"git grep 'search string'\" here"
	@echo "and inside the 'openembedded' subdirectory."
	@echo
	@if [ -z "$(GIT_USER_NAME)" -o -z "$(GIT_USER_EMAIL)" ]; then \
		echo "Before doing any commits, please configure your name and email"; \
		echo "address using the following commands:"; \
		echo; \
		echo "  $$ $(GIT) config user.name \"Your Name\""; \
		echo "  $$ $(GIT) config user.email \"mail@example.com\""; \
	else \
		echo "Git has been configured for $(GIT_USER_NAME) <$(GIT_USER_EMAIL)>."; \
		echo "Please submit patches to <enigma2-devel@lists.elitedvb.net>."; \
	fi

usage:
	@echo "[*] Please run 'make help' to display further information!"

clean:
	@echo '[*] Deleting generated configuration files'
	@$(RM) $(CONFFILES)

doc:
	@make -C doc

image: update
	@echo '[*] Building image'
	@. $(PWD)/bitbake.env && cd $(TOPDIR) && bitbake dreambox-image

download: $(CONFFILES)
	@echo '[*] Downloading sources'
	@. $(PWD)/bitbake.env && cd $(TOPDIR) && bitbake -cfetchall -k dreambox-image

update: $(CONFFILES)
	@echo '[*] Updating Git repositories...'
	@if [ -n "$(GIT_REMOTE)" ]; then $(GIT) pull --ff-only || $(GIT) pull --rebase; fi
	@$(GIT) submodule sync
	@$(GIT) submodule update --init
	@echo "[*] The Dreambox SDK is now up-to-date."

.PHONY: all clean doc help image update usage

$(TOPDIR)/conf/bblayers.conf:
	@echo '[*] Generating $@'
	@test -d $(@D) || mkdir -p $(@D)
	@echo 'LCONF_VERSION = "4"' > $@
	@echo 'BBFILES = ""' >> $@
	@echo 'BBLAYERS = "$(BBLAYERS)"' >> $@
	@test -f $(@F).append && cat $(@F).append >> $@ || true

$(TOPDIR)/conf/local.conf:
	@echo '[*] Generating $@'
	@test -d $(@D) || mkdir -p $(@D)
	@echo 'TOPDIR = "$(TOPDIR)"' > $@
	@echo 'BB_NUMBER_THREADS = "$(BB_NUMBER_THREADS)"' >> $@
	@echo 'PARALLEL_MAKE = "$(PARALLEL_MAKE)"' >> $@
	@echo 'MACHINE = "$(MACHINE)"' >> $@
	@echo 'DL_DIR = "$(DL_DIR)"' >> $@
	@echo 'SSTATE_DIR = "$(SSTATE_DIR)"' >> $@
	@echo 'TMPDIR = "$(TMPDIR)"' >> $@
	@echo 'EXTRA_IMAGE_FEATURES = "debug-tweaks"' >> $@
	@echo 'USER_CLASSES = "buildstats"' >> $@
	@echo 'CONF_VERSION = "1"' >> $@
	@echo 'BB_GENERATE_MIRROR_TARBALLS = "0"' >> $@
	@echo 'BB_SCHEDULER = "$(BB_SCHEDULER)"' >> $@
	@echo 'BBINCLUDELOGS = "yes"' >> $@
	@echo 'DISTRO = "opendreambox"' >> $@
	@test "$(RM_WORK)" = "yes" && echo 'INHERIT += "rm_work"' >> $@ || true
	@test -f $(@F).append && cat $(@F).append >> $@ || true

bitbake.env:
	@echo '[*] Generating $@'
	@echo 'export BUILDDIR=$(TMPDIR)' >> $@
	@echo 'export PATH=$(PWD)/openembedded-core/scripts:$(PWD)/bitbake/bin:$${PATH}' >> $@

compiler-%.env:
	@echo '[*] Generating $@'
	@echo 'export PATH=$(TMPDIR)/sysroots/$(shell uname -m)-linux/usr/bin/$*-oe-linux:$${PATH}' > $@
