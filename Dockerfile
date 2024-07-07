FROM openjdk:17-alpine
EXPOSE 8090
ADD target/kg20294730_cat-0.0.1-SNAPSHOT.jar kg20294730_cat-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/","kg20294730_cat-0.0.1-SNAPSHOT.jar" ]