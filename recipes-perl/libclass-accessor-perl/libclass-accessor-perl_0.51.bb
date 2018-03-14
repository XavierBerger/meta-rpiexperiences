DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=40;endline=44;md5=d4e6323f04f9b0d2ab01e63122905544"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl libsub-name-perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/K/KA/KASEI/Class-Accessor-${PV}.tar.gz"

SRC_URI[md5sum] = "1f1e5990f87cad7659b292fed7dc0407"
SRC_URI[sha256sum] = "bf12a3e5de5a2c6e8a447b364f4f5a050bf74624c56e315022ae7992ff2f411c"

S = "${WORKDIR}/Class-Accessor-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

