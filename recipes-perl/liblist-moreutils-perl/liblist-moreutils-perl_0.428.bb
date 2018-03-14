DESCRIPTION = ""

SECTION = "libs"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

DEPENDS += "perl "
RDEPENDS_${PN} = "perl libexporter-tiny-perl"

SRC_URI = "https://cpan.metacpan.org/authors/id/R/RE/REHSACK/List-MoreUtils-${PV}.tar.gz"

SRC_URI[md5sum] = "493032a211cdff1fcf45f59ebd680407"
SRC_URI[sha256sum] = "713e0945d5f16e62d81d5f3da2b6a7b14a4ce439f6d3a7de74df1fd166476cc2"

S = "${WORKDIR}/List-MoreUtils-${PV}"

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR} LIBS=-L${STAGING_LIBDIR}"

inherit cpan

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}

