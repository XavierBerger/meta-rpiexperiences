DESCRIPTION = "RPi-Monitor - Powerfull monitoring tool for embedded system"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

#SRC_URI  = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"
#SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=develop"
SRC_URI  = "git://github.com/XavierBerger/RPi-Monitor.git;protocol=git;branch=feature/fix_Makefile"

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

PACKAGECONFIG ??= "snmp web"
PACKAGECONFIG[man] = "--with-man"
PACKAGECONFIG[snmp] = "--with-snmp"
PACKAGECONFIG[conf] = "--with-conf"
PACKAGECONFIG[web] = "--with-web"
PACKAGECONFIG[scripts] = "--with-scripts"
PACKAGECONFIG[examples] = "--with-examples"
PACKAGECONFIG[templates] = "--with-templates"
PACKAGECONFIG[cron] = "--with-cron"

do_configure() {
    INIT="None"
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        INIT="systemd"
    fi

    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        INIT="sysVinit"
    fi

    bbnote "./configure --dest ${D} --init ${INIT} ${PACKAGECONFIG_CONFARGS}"
    ./configure --dest ${D} --init ${INIT} ${PACKAGECONFIG_CONFARGS}
}

do_compile[noexec] = "1"

do_install() {
    make install
    sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/bin/rpimonitord
    if ${@bb.utils.contains('PACKAGECONFIG', 'web', 'true', 'false', d)}; then
        sed -i "s/{DEVELOPMENT}/${PV}-${PR}/" ${D}/usr/share/rpimonitor/web/js/rpimonitor.js
    fi
}

inherit systemd update-rc.d

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "rpimonitord.service"
SYSTEMD_SERVICE_${PN}_append = " ${@bb.utils.contains('PACKAGECONFIG', 'scripts', 'top3.service top3.timer', '', d)}"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "rpimonitord"
INITSCRIPT_PARAMS_${PN} = "defaults 20"

FILES_${PN} += "/usr/ /etc/ /var/ /lib/"