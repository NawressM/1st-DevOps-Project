FROM maven:3.6.3-openjdk-11 as builder
COPY . /usr/src/devops
WORKDIR /usr/src/devops
RUN mvn package

FROM tomcat:8.0-alpine
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m"
COPY config/tomcat-users.xml /usr/local/tomcat/conf/
COPY --from=builder /usr/src/devops/target /usr/local/tomcat/webapps/

EXPOSE 8080

