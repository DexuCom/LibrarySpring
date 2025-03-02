FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="library-gateway"
LABEL org.opencontainers.image.authors="Patryk (Dexu) Sawuk"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="Library"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV RPG_GATEWAY_HOST=localhost:8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

EXPOSE 8080

COPY target/library-gateway-${VERSION}.jar /opt/library-gateway/library-gateway.jar

CMD ["java", "-jar", "/opt/library-gateway/library-gateway.jar"]
