# POC GIS Spring Boot

A small Kotlin/Spring Boot starter used to validate the web/API side of a GIS proof of concept.

## What it contains

- Kotlin + Spring Boot
- Simple REST endpoint for smoke testing
- Swagger configuration
- PostgreSQL driver
- A PostGIS Docker base under `forGIS/`

This repository is the lightweight Spring Boot starter. The companion repository `kris-atelier/POC-GISAPI` contains the actual PostGIS polygon API example.

## Requirements

- JDK 17

## Run

```bash
./gradlew clean test
./gradlew bootRun
```

Smoke-test the service:

```bash
curl http://localhost:8080/hello
```

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/
```

## PostGIS image

The `forGIS/Dockerfile` now uses the official PostGIS image rather than compiling PostGIS from source.

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

## Public POC scope

This project is intentionally small. It exists to demonstrate a reproducible Spring Boot starting point for GIS-related experiments, not a production-ready spatial service. For the end-to-end PostGIS API example, see the companion `POC-GISAPI` repository.
