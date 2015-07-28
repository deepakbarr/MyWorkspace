#!/bin/sh
java -jar dropwizard-service-1.0-SNAPSHOT.jar server configuration.yml >~/install/service-drop-wiz/log/service-log.log &

#java -jar target/dropwizard-service-1.0-SNAPSHOT.jar server dropwiz-deb/configuration.yml