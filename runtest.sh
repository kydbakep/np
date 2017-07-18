#! /bin/sh

Xvfb :10&
mvn clean test -P my_profile