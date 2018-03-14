DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=6;endline=7;md5=7239ea722af9acca2efbb8a5d913286e"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl libsub-name-perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/A/AM/AMS/Storable-${PV}.tar.gz"

SRC_URI[md5sum] = "48082965a6403a8c5adcd42aeb0c58e5"
SRC_URI[sha256sum] = "a566b792112bbba21131ec1d7a2bf78170c648484895283ae53c7f0c3dc2f0be"

S = "${WORKDIR}/Storable-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

