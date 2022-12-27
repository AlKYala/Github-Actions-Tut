# NO CI just build from jar

# recommended package
FROM amazoncorretto:17-alpine-jdk

MAINTAINER Ali Yalama
#build is in target folder so copy it INTO THE IMAGE
COPY target/Github-Actions-Tut-1.0.jar Github-Actions-Tut-1.0.jar
# syntax just follows split(" ")
ENTRYPOINT ["java", "-jar", "/Github-Actions-Tut-1.0.jar"]