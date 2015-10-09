#!/bin/bash

./createdb.sh

sudo docker stop server
sudo docker rm server

sudo docker run --name server -it -p 8081:8080 --link gradplannerBD:gradplannerBD -v ~/deployments:/opt/jboss/wildfly/standalone/deployments/:rw jboss/wildfly:latest
