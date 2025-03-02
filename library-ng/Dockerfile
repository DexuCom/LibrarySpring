FROM nginx:1.23.3

LABEL org.opencontainers.image.title="library-ng"
LABEL org.opencontainers.image.authors="Patryk (Dexu) Sawuk"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="Library"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV API_URL http://localhost:8083/api

EXPOSE 80

ADD dist/library-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
