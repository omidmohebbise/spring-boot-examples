#!/bin/bash

./gradlew clean build;
docker compose up --build -d;