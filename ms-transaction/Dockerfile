FROM openjdk:13
EXPOSE 8009
ADD ./target/ms-transaction-0.0.1-SNAPSHOT.jar    app-transaction.jar
ENTRYPOINT ["java","-jar","/app-transaction.jar"]
