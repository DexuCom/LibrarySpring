#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./library-books/; ./build.sh; cd ..
    cd ./library-lib/; ./build.sh; cd ..
    cd ./library-gateway/; ./build.sh; cd ..
    cd ./library-ng/; ./build.sh; cd ..
    cd ./library-rpg-eureka/; ./build.sh; cd ..
}

main "$@"
