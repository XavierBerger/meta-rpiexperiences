DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=432;endline=434;md5=57198f409c9f89bf1b68d8e8d898c893"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TO/TODDR/Exporter-${PV}.tar.gz"

SRC_URI[md5sum] = "096f0692cbe46a3407a534a0d10970ca"
SRC_URI[sha256sum] = "cd13b7a0e91e8505a0ce4b25f40fab2c92bb28a99ef0d03da1001d95a32f0291"

S = "${WORKDIR}/Exporter-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
