# NO CI just build from jar

# recommended package
FROM amazoncorretto:17-alpine-jdk

MAINTAINER Ali Yalama
#build is in target folder so copy it INTO THE IMAGE
COPY target/Github-Actions-Tut-1.1.jar Github-Actions-Tut-1.1.jar
# syntax just follows split(" ")
ENTRYPOINT ["java", "-Dspring.profiles.active=stg", "-jar", "/Github-Actions-Tut-1.1.jar"]