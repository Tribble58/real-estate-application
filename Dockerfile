FROM eclipse-temurin:17

COPY ./target/real-estate-*.jar ./application.jar
ENTRYPOINT ["java","-jar","/application.jar"]