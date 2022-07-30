plugins {
    java
    id("org.openapi.generator") version "6.0.1"
}

group = "org"
version = "1.0"

repositories {
    mavenCentral()
}

openApiGenerate {
    generatorName.set("spring")
    apiPackage.set("rest.api")
    modelPackage.set("rest.dto")
    outputDir.set("$buildDir/generated/")
    inputSpec.set("$rootDir/specs/self-learning-platform.yaml")
}

tasks.openApiGenerate {
    doLast {
        delete (
                "$buildDir/generated/.openapi-generator",
                "$buildDir/generated/src/main/java/org",
                "$buildDir/generated/src/main/resources",
                "$buildDir/generated/src/test",
        )
    }
}