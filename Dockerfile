FROM eclipse-temurin:17 as app-build

ENV APP_BUILD_DIR=/opt/build

WORKDIR ${APP_BUILD_DIR}
COPY ./target/real-estate-*.jar ./application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17

ENV APP_BUILD_DIR=/opt/build

RUN groupadd --gid 1000 real-estate-service-app \
  && useradd --uid 1000 --gid real-estate-service-app --shell /bin/bash --create-home real-estate-service-app
USER real-estate-service-app:real-estate-service-app
WORKDIR /opt/real-estate-service

COPY --from=app-build ${APP_BUILD_DIR}/spring-boot-loader/ ./
COPY --from=app-build ${APP_BUILD_DIR}/dependencies/ ./
COPY --from=app-build ${APP_BUILD_DIR}/snapshot-dependencies/ ./
COPY --from=app-build ${APP_BUILD_DIR}/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
