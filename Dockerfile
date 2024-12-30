FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /home/app
COPY ./ ./source
RUN cd ./source && mvn -DskipTests=true clean package

FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl
WORKDIR /home/app
COPY --from=builder /home/app/source/api/target/lesson7-*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "-Dfile-encoding=UTF-8", "/home/app/app.jar"]
