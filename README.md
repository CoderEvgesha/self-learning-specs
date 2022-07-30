# Specification for self-learning platform

The project is based on OpenApi format and supposed to be a helper for generating resources.

## Available languages for generation

1. Java

## Specification path

The specification is located at **specs/self-learning-platform.yaml**

## How use it

For Java class generation you should run the next command in terminal:
```bash
./gradlew clean openApiGenerate
```
Generated files are located at build/generated.