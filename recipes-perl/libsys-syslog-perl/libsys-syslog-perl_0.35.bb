DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=57;endline=62;md5=852678bfe81d9f4ffd6996de156a3307"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl libsub-name-perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/S/SA/SAPER/Sys-Syslog-${PV}.tar.gz"

SRC_URI[md5sum] = "59dfb279f78a5ff587ba2ee8989b13e8"
SRC_URI[sha256sum] = "fe28e47b70b77aaae754385fe1470d174289e7b6908efa247d2e52486516fbb7"

S = "${WORKDIR}/Sys-Syslog-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

