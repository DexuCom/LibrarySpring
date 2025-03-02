FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="library-eureka"
LABEL org.opencontainers.image.authors="Patryk (Dexu) Sawuk"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="Library"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_INSTANCE_HOSTNAME=localhost

ENV EUREKA_CLIENT_FETCH_REGISTRY=false
ENV EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8080/eureka

ENV EUREKA_SERVER_ENABLE_SELF_PRESERVATION=false
ENV EUREKA_SERVER_EVICTION_INTERVAL_TIMER_IN_MS=2000

EXPOSE 8080

COPY target/library-eureka-${VERSION}.jar /opt/library-eureka/library-eureka.jar

CMD ["java", "-jar", "/opt/library-eureka/library-eureka.jar"]
