DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
#SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=devel"
SRC_URI += "file://rpimonitor.init.patch"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[md5sum] = "9ec0785a3e7f7c464410b793c6574238"
SRC_URI[sha256sum] = "797336ebd7abbf0e635e1fbae9df6fb485112cfd916073f9b46330d7ad4636b9"
#SRCREV="${AUTOREV}"

RDEPENDS_${PN} = "bash \
                  perl libfile-which-perl libwww-perl libipc-sharelite-perl libjson-perl \
				          perl-module-posix perl-module-data-dumper perl-module-io-handle \
				          perl-module-io-socket perl-module-file-glob rrdtool-perl \
				          perl-module-sys-hostname perl-module-file-basename"

S="${WORKDIR}/RPi-Monitor-${PV}"
#S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "build-deps"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install() {
  cd ${S}
  export TARGETDIR=${D}/
  make install
  sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/bin/rpimonitord
  sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/share/rpimonitor/web/js/rpimonitor.js
  rm ${D}/usr/share/rpimonitor/scripts/sunxi_tp_temp
  rm ${D}/usr/share/rpimonitor/scripts/sunxi-temp-daemon.sh
}

INITSCRIPT_NAME = "rpimonitor"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 . stop 20 0 1 6 ."
inherit update-rc.d
