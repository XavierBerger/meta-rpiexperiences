DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
#SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=devel"
SRC_URI += "file://rpimonitor.init.patch"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[md5sum] = "93cb34964a9f5fe33bedca63b6d6f5d8"
SRC_URI[sha256sum] = "4b20a26d8fa3b528e32e659884a5ab131b5fbcd11c6b0abeffb6113fac1d69fd"
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
}

pkg_postinst_${PN}() {
#!/bin/sh -e
# reinstall the service
update-rc.d -f rpimonitor remove
update-rc.d -f rpimonitor defaults
# start RPi-Monitor
/etc/init.d/rpimonitor restart
}
