PREMIRRORS =+ " \
cvs://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
ftp://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
svn://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
"

MIRRORS =+ " \
${DEBIAN_MIRROR}        http://snapshot.debian.org/archive/debian/20110301T040946Z/pool \n \
${DEBIAN_MIRROR}        http://snapshot.debian.org/archive/debian/20110901T033808Z/pool \n \
"

MIRRORS += " \
bzr://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
ftp://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
git://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
hg://.*/.*              http://dreamboxupdate.com/sources-mirror/ \n \
https?$://.*/.*         http://dreamboxupdate.com/sources-mirror/ \n \
osc://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
p4://.*/.*              http://dreamboxupdate.com/sources-mirror/ \n \
svk://.*/.*             http://dreamboxupdate.com/sources-mirror/ \n \
"

#PREMIRRORS_append() {
#cvs://.*/.*	http://dreamboxupdate.com/sources-mirror/
#svn://.*/.*	http://dreamboxupdate.com/sources-mirror/
#}

#MIRRORS_prepend() {
#${DEBIAN_MIRROR}	http://snapshot.debian.org/archive/debian/20110301T040946Z/pool
#${DEBIAN_MIRROR}	http://snapshot.debian.org/archive/debian/20110901T033808Z/pool
#}

#MIRRORS_append() {
#bzr://.*/.*	http://dreamboxupdate.com/sources-mirror/
#ftp://.*/.*	http://dreamboxupdate.com/sources-mirror/
#git://.*/.*	http://dreamboxupdate.com/sources-mirror/
#hg://.*/.*	http://dreamboxupdate.com/sources-mirror/
#https?$://.*/.*	http://dreamboxupdate.com/sources-mirror/
#}
