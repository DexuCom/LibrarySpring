FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="library-books"
LABEL org.opencontainers.image.authors="Patryk (Dexu) Sawuk"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="Library"
LABEL org.opencontainers.image.licenses="MIT"


LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:library-books
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

EXPOSE 8080

COPY target/library-books-${VERSION}.jar /opt/library-books/library-books.jar

CMD ["java", "-jar", "/opt/library-books/library-books.jar"]
