# Gradle Library Template

Kotlin/JVM library starter for GitHub Packages and JitPack.

## Publishing

The project applies `maven-publish`.

For GitHub Packages, CI uses the built-in `GITHUB_ACTOR` and `GITHUB_TOKEN` credentials. Local publishing can use Gradle properties `gpr.user`, `gpr.key`, and `GITHUB_REPOSITORY`.

JitPack builds the Maven publication from tagged revisions and requires no repository secret.

Change `GROUP`, `VERSION_NAME`, and `POM_ARTIFACT_ID` in `gradle.properties`.

## Workflows

This template requests `ci-validation` and `maven-package-publish` in `.github/workflow-request.yml`. New workflow implementations belong in `HereLiesAz/workflows`.
