DESCRIPTION = "RPi-Monitor"
AUTHOR = "Xavier Berger"
HOMEPAGE = "http://rpi-experiences.blogspot.fr"
LICENSE = "GPLv3"

SRC_URI = "https://github.com/XavierBerger/RPi-Monitor/archive/v${PV}.tar.gz"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[md5sum] = "3eb2781f9d1fb7f7ec47121c16fd7d47"
SRC_URI[sha256sum] = "e081ffd1439c6f490a74b96097c715d00eee85d457ae96e5058990b16c7a4d97"

RDEPENDS_${PN} = "libfile-which-perl libhttp-daemon-perl libipc-sharelite-perl libjson-perl "

S="${WORKDIR}/RPi-Monitor-${PV}"

do_install() {
	cd ${S}
	install -d ${D}/usr/bin/
	install -m 0755 ${S}/rpimonitor/rpimonitord ${D}/usr/bin/
}
