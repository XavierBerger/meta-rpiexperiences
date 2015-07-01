DESCRIPTION = "Time::Local - efficiently compute time from local and GMT time"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://LICENSE;md5=0f4e05a25acd9fdcf66b1a99afbf0adf"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Time-Local-${PV}.tar.gz"

SRC_URI[md5sum] = "68e1be54c151cf131f9d4168b3e662f9"
SRC_URI[sha256sum] = "b2acca03700a09f8ae737d3084f3f6287e983da9ab7b537c6599c291b669fb49"

S = "${WORKDIR}/Time-Local-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
