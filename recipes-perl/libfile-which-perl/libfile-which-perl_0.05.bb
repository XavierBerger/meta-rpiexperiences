DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=54;endline=55;md5=da89af04272cf2e195e17848a2af70e3"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PEREINAR/File-Which-${PV}.tar.gz"

SRC_URI[md5sum] = "bd671a65f770fc0a124095e74c7c8013"
SRC_URI[sha256sum] = "ee85f83119c7a5952c2a44a0183ea5c0809e98129a3473ee36cdf2227c836765"

S = "${WORKDIR}/File-Which-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

