DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=40;endline=41;md5=62e24a93342fede7221d66335c716f34"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Carp-${PV}.tar.gz"

SRC_URI[md5sum] = "3f5dcd7cc263bd01617886174ceff5a4"
SRC_URI[sha256sum] = "dcc789935126461c80df0653f98c1d8d0b936dcc3d04174287cb02767eca123c"

S = "${WORKDIR}/Carp-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
