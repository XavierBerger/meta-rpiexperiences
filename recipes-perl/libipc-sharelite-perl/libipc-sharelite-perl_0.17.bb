DESCRIPTION = "IPC::ShareLite - Lightweight interface to shared memory"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=15;endline=16;md5=2e544ca0be03e069a3929a04e32af884"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl perl-module-subs perl-module-dynaloader perl-module-autoloader "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AN/ANDYA/IPC-ShareLite-${PV}.tar.gz"

SRC_URI[md5sum] = "54c7aa08dc065b6c946c48491d33450d"
SRC_URI[sha256sum] = "14d406b91da96d6521d0d1a82d22a306274765226b86b0a56e7ffddcf96ae7bf"

S = "${WORKDIR}/IPC-ShareLite-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
