DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://LICENCE;md5=4b51fc9b030517a3896e5f8cb6ab07e0"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/E/ET/ETHER/Sub-Name-${PV}.tar.gz"

SRC_URI[md5sum] = "7e7a181e30b3249d0b81585f55e36621"
SRC_URI[sha256sum] = "bd32e9dee07047c10ae474c9f17d458b6e9885a6db69474c7a494ccc34c27117"

S = "${WORKDIR}/Sub-Name-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

