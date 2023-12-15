FROM openjdk:17-oracle

ARG JAR_FILE
ARG PROFILE

ENV SPRING_PROFILES_ACTIVE ${PROFILE}

COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT java -jar -Dspring.profiles.active="$SPRING_PROFILES_ACTIVE" -Duser.timezone=Asia/Seoul /app.jar
