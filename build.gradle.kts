plugins {
    kotlin("jvm") version "2.4.20"
    `java-library`
    `maven-publish`
}

group = providers.gradleProperty("GROUP").get()
version = providers.gradleProperty("VERSION_NAME").get()

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
    withJavadocJar()
}

repositories { mavenCentral() }

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test { useJUnitPlatform() }

publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            artifactId = providers.gradleProperty("POM_ARTIFACT_ID").get()
        }
    }

    val repositoryName = providers.environmentVariable("GITHUB_REPOSITORY")
        .orElse(providers.gradleProperty("GITHUB_REPOSITORY"))
        .orNull
    if (!repositoryName.isNullOrBlank()) {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/$repositoryName")
                credentials {
                    username = providers.environmentVariable("GITHUB_ACTOR").orNull
                        ?: providers.gradleProperty("gpr.user").orNull
                    password = providers.environmentVariable("GITHUB_TOKEN").orNull
                        ?: providers.gradleProperty("gpr.key").orNull
                }
            }
        }
    }
}
