Work in progress
================

meta-rpiexperiences
===================

This layer provides **RPi-Monitor** moniritoring tools and its dependencies.

Dependencies
============

This layer depends on:

```
  URI: git://git.openembedded.org/openembedded-core
  branch: master
  revision: HEAD
  prio: default

  URI: git://git.openembedded.org/meta-openembedded/meta-oe
  branch: master
  revision: HEAD
  prio: default

  URI: git://git.openembedded.org/meta-openembedded/meta-perl
  branch: master
  revision: HEAD
  prio: default
```

Adding RPi-Experiences layer to your build
==========================================

In order to use this layer, you need to make the build system aware of
it.

Assuming the rpi-experiences layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the security layer to bblayers.conf, along with any
other layers needed. e.g.:

```
  BBLAYERS ?= " \
    /path/to/oe-core/meta \
    /path/to/meta-openembedded/meta-oe \
    /path/to/meta-openembedded/meta-perl \
    /path/to/layer/meta-rpiexperiences \
    ...
    "
```
    
Contents and Help
=================

In this section the contents of the layer is listed, along with a short
help for each package.

recipes-perl
------------
This directory contains all the perl recipes needed for **RPi-Monitor**.

recipes-rpimonitor
------------------
This directory contains **RPi-Monitor** recipe.
         
Maintenance
-----------
Send pull requests, patches, comments or questions to <https://github.com/XavierBerger/meta-rpiexperiences/issues>

Maintainer:    Xavier Berger <berger.xavier@gmail.com>

License
=======

All metadata is GPLv3 licensed unless otherwise stated. Source code included in tree for individual recipes is under the LICENSE stated in each recipe (.bb file) unless otherwise stated.
