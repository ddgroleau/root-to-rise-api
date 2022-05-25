#!/bin/bash

mvn install -DskipTests
docker build -t dangroleau/root-to-rise-api .
docker push dangroleau/root-to-rise-api
docker-compose up -d
