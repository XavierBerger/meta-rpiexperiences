DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
#SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=devel"
SRC_URI += "file://rpimonitor.init.patch"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[md5sum] = "4b418b0337ca3cad8c3e9dccd161d5e8"
SRC_URI[sha256sum] = "b1bc7617a0e5fae6f0376bd20c92f21383f9be7982ddad079994a587c51dcb59"
#SRCREV="8cee56ff46007247ac09e5355e3e142581c2b9ae"

RDEPENDS_${PN} = "perl libfile-which-perl libwww-perl libipc-sharelite-perl libjson-perl \
				  perl-module-posix perl-module-data-dumper perl-module-io-handle \
				  perl-module-io-socket perl-module-file-glob rrdtool-perl \
				  perl-module-sys-hostname perl-module-file-basename"

S="${WORKDIR}/RPi-Monitor-${PV}"
#S = "${WORKDIR}/git"

#

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install() {
  cd ${S}
  export TARGETDIR=${D}/
  make install
  sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/bin/rpimonitord
  sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/share/rpimonitor/web/js/rpimonitor.js
}

pkg_postinst_${PN}() {
#!/bin/sh -e
# reinstall the service
update-rc.d -f rpimonitor remove
update-rc.d -f rpimonitor defaults
# start RPi-Monitor
/etc/init.d/rpimonitor restart
}
