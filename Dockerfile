
FROM amazoncorretto:17.0.3

COPY src ./src

RUN javac src/*.java -d out

WORKDIR out

EXPOSE 9090

CMD ["java", "App"]
