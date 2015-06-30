DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=235;endline=236;md5=ece56418b0d00a071b6e5e89f1188c7e"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTTP-Daemon-${PV}.tar.gz"

SRC_URI[md5sum] = "ed0ae02d25d7f1e89456d4d69732adc2"
SRC_URI[sha256sum] = "43fd867742701a3f9fcc7bd59838ab72c6490c0ebaf66901068ec6997514adc2"

S = "${WORKDIR}/HTTP-Daemon-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
