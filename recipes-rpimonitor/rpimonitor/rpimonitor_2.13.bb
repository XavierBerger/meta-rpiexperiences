DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

#SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=develop"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

#SRC_URI[md5sum] = "9ec0785a3e7f7c464410b793c6574238"
#SRC_URI[sha256sum] = "797336ebd7abbf0e635e1fbae9df6fb485112cfd916073f9b46330d7ad4636b9"
SRCREV="${AUTOREV}"

RDEPENDS_${PN} = "bash \
                  perl libfile-which-perl libwww-perl libipc-sharelite-perl libjson-perl \
				          perl-module-posix perl-module-data-dumper perl-module-io-handle \
				          perl-module-io-socket perl-module-file-glob rrdtool-perl \
				          perl-module-sys-hostname perl-module-file-basename libsnmp-extension-passpersist-perl"

#S="${WORKDIR}/RPi-Monitor-${PV}"
S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "build-deps"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install() {
    install -d ${D}/var/lib/rpimonitor
    cp -r ${S}/src/var/lib/rpimonitor/* ${D}/var/lib/rpimonitor/
    install -d ${D}/etc/rpimonitor
    cp -r ${S}/src/etc/rpimonitor/* ${D}/etc/rpimonitor/
    install -d ${D}/etc/snmp
    cp -r ${S}/src/etc/snmp/* ${D}/etc/snmp/
    install -d ${D}/usr/bin
    cp -r ${S}/src/usr/bin/* ${D}/usr/bin/
    install -d ${D}/usr/share/rpimonitor/scripts
    cp ${S}/src/usr/share/rpimonitor/scripts/updatePackagesStatus.pl ${D}/usr/share/rpimonitor/scripts/
    install -d ${D}/usr/share/rpimonitor/web
    cp -r ${S}/src/usr/share/rpimonitor/web/* ${D}/usr/share/rpimonitor/web/
    install -d ${D}${systemd_system_unitdir}
    cp -r ${S}/src/usr/lib/systemd/system/rpimonitord* ${D}${systemd_system_unitdir}

    sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/bin/rpimonitord
    sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/share/rpimonitor/web/js/rpimonitor.js
}

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "rpimonitord.service rpimonitord-upgradable.service rpimonitord-upgradable.timer"

FILES_${PN} += "/usr/ /etc/ /var/ /lib/"