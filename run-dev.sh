#!/bin/bash

mvn install -DskipTests
sudo service postgresql start
export SPRING_ACTIVE_PROFILES=dev
./mvnw spring-boot:run

