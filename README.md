# POC GIS Spring Boot

[![CI](https://github.com/kris-atelier/poc-gis-spring/actions/workflows/ci.yml/badge.svg)](https://github.com/kris-atelier/poc-gis-spring/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A small Kotlin/Spring Boot starter used to validate the web/API side of a GIS proof of concept.

## What it demonstrates

- Kotlin + Spring Boot 2.7
- Simple REST endpoint for smoke testing
- Swagger configuration
- PostgreSQL driver integration
- Reproducible PostGIS Docker base under `forGIS/`
- GitHub Actions validation on JDK 17

This repository is the lightweight Spring Boot starter. For the end-to-end spatial API example, see [POC-GISAPI](https://github.com/kris-atelier/POC-GISAPI).

## Requirements

- JDK 17
- Docker, only if you want to run the PostGIS image

## Run

```bash
./gradlew clean test
./gradlew bootRun
```

Smoke-test the service:

```bash
curl http://localhost:8080/hello
```

Expected response:

```text
Hello
```

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/
```

## PostGIS image

The `forGIS/Dockerfile` uses the official PostGIS image rather than compiling PostGIS from source.

```bash
docker build -t poc-postgis ./forGIS
```

Example run:

```bash
docker run --rm \
  -e POSTGRES_DB=GIS \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  poc-postgis
```

The credentials above are for local development only.

## Verification

CI validates the project on JDK 17 by running the Gradle test/build lifecycle and building the PostGIS Docker image.

## Public POC scope

This project is intentionally small. It demonstrates a reproducible Spring Boot starting point for GIS-related experiments rather than a production-ready spatial service.

For PostgreSQL/PostGIS persistence, geometry mapping and a runnable REST endpoint, continue with [POC-GISAPI](https://github.com/kris-atelier/POC-GISAPI).
