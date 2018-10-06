FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/thinkpro-customer-0.0.1-SNAPSHOT.jar thinkpro-customer.jar
RUN sh -c 'touch /thinkpro-customer.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/thinkpro-customer.jar"]
EXPOSE 9091
