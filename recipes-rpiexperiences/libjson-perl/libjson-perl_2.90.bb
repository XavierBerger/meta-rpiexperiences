DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=1584;endline=1585;md5=ece56418b0d00a071b6e5e89f1188c7e"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MAKAMAKA/JSON-${PV}.tar.gz"

SRC_URI[md5sum] = "e1512169a623e790a3f69b599cc1d3b9"
SRC_URI[sha256sum] = "4ddbb3cb985a79f69a34e7c26cde1c81120d03487e87366f9a119f90f7bdfe88"

S = "${WORKDIR}/JSON-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}


