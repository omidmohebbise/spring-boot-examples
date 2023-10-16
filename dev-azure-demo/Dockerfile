#
# Build stage
#
FROM openjdk:17.0.2-slim-buster AS build
WORKDIR /home/app

COPY ./src /home/app/src
COPY ./gradle /home/app/gradle
COPY ./gradlew /home/app/gradlew
COPY ./build.gradle /home/app/build.gradle
COPY ./settings.gradle /home/app/settings.gradle

RUN ./gradlew clean build

#
# Package stage
#
FROM openjdk:17.0.1-slim AS base

WORKDIR /app

COPY --from=build /home/app/build/libs/dev-azure-demo-demoapp.jar /app/application.jar

COPY ./entrypoint.sh /app/entrypoint.sh

RUN chmod +x /app/entrypoint.sh

ENTRYPOINT /app/entrypoint.sh



