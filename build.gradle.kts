plugins {
    java
    `maven-publish`
    id("org.openapi.generator") version "6.0.1"
}

group = "org.hermit"
version = "1.0"

repositories {
    mavenCentral()
}

openApiGenerate {
    generatorName.set("spring")
    apiPackage.set("$group.rest.api")
    modelPackage.set("$group.rest.dto")
    outputDir.set("$buildDir/generated/")
    inputSpec.set("$rootDir/specs/self-learning-platform.yaml")
}

tasks.openApiGenerate {
    doLast {
        delete(
                "$buildDir/generated/.openapi-generator",
                "$buildDir/generated/src/main/java/org/openapitools",
                "$buildDir/generated/src/main/resources",
                "$buildDir/generated/src/test",
        )

        delete(fileTree("$buildDir/generated/").matching {
            include("src/main/java/org/hermit/rest/api/**ApiController.java")
        })
    }
}

tasks.jar {
    dependsOn(tasks.openApiGenerate)
    from("build/generated/src/main/java")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "library"
            from(components["java"])
        }
    }
}