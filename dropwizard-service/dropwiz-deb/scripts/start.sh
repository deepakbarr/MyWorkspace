#!/bin/sh
java -jar dropwizard-service-1.0-SNAPSHOT.jar server configuration.yml >~/install/service-drop-wiz/log/service-log.log &
