DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

#SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=devel"
SRC_URI += "file://rpimonitor.init.patch"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

#SRC_URI[md5sum] = "3eb2781f9d1fb7f7ec47121c16fd7d47"
#SRC_URI[sha256sum] = "e081ffd1439c6f490a74b96097c715d00eee85d457ae96e5058990b16c7a4d97"
SRCREV="d229f59f7695a532f57f4ec1c60400dd775c3caa"

RDEPENDS_${PN} = "perl libfile-which-perl libwww-perl libipc-sharelite-perl libjson-perl \
				  perl-module-posix perl-module-data-dumper perl-module-io-handle \
				  perl-module-io-socket perl-module-file-glob rrdtool-perl \
				  perl-module-sys-hostname perl-module-file-basename"

#S="${WORKDIR}/RPi-Monitor-${PV}"
S = "${WORKDIR}/git"

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
