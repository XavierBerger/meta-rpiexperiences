DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=60;endline=61;md5=b2725e2164ecaeab82c4f6bd861a9b7f"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/constant-${PV}.tar.gz"

SRC_URI[md5sum] = "4ee93d57fbd8dfbc4c902c495614d5f0"
SRC_URI[sha256sum] = "79965d4130eb576670e27ca0ae6899ef0060c76da48b02b97682166882f1b504"

S = "${WORKDIR}/constant-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
