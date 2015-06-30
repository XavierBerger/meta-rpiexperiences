DESCRIPTION = "LWP - The World-Wide Web library for Perl"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

LIC_FILES_CHKSUM = "file://README;beginline=90;endline=91;md5=d2b1a88dc9b5db3276b2450fba42a99b"

DEPENDS += "perl "

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/libwww-perl-${PV}.tar.gz"

SRC_URI[md5sum] = "9bbf1bce482b0bac98bb4f04253c03d0"
SRC_URI[sha256sum] = "4f651e9241df8fccd2eeb125eb6a3bfddcfc65f49adb5469313fe4a95aaded45"

S = "${WORKDIR}/libwww-perl-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

