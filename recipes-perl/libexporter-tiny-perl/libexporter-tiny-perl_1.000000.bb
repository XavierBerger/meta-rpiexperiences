DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://LICENSE;md5=69d4f838f536b9e3ac1ab083ec72c9c9"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/T/TO/TOBYINK/Exporter-Tiny-${PV}.tar.gz"


SRC_URI[md5sum] = "0d413747bdcf880f9ec62de8801ccf5e"
SRC_URI[sha256sum] = "ffdd77d57de099e8f64dd942ef12a00a3f4313c2531f342339eeed2d366ad078"

S = "${WORKDIR}/Exporter-Tiny-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

