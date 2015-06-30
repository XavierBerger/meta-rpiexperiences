DESCRIPTION = "HTTP::Request - HTTP style request message"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=19;endline=20;md5="

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTTP-Message-${PV}.tar.gz"

SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""

S = "${WORKDIR}/HTTP-Message-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
