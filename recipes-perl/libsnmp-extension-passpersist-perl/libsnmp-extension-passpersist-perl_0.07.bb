DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=56;endline=61;md5=765672f6570024f9779c2bb2c106376c"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl libclass-accessor-perl liblist-moreutils-perl libstorable-perl libsys-syslog-perl libsys-syslog-perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/S/SA/SAPER/SNMP-Extension-PassPersist-${PV}.tar.gz"

SRC_URI[md5sum] = "9930746a8a4e2b22325d609cebda959b"
SRC_URI[sha256sum] = "59474d5196bc87f875806eb3b49afdaa7b4784086ebce5f5ebbab57c288a713e"

S = "${WORKDIR}/SNMP-Extension-PassPersist-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

