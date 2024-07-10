FROM openjdk:8 
VOLUME /tmp 
ADD ./target/clientes-api-0.0.1-SNAPSHOT.jar clientes-api.jar 
ENTRYPOINT [ "java", "-jar", "/clientes-api.jar" ]