FROM openjdk:13
EXPOSE 8007
ADD ./target/ms-invoice-0.0.1-SNAPSHOT.jar    app-invoices.jar
ENTRYPOINT ["java","-jar","/app-invoices.jar"]
