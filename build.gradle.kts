plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"

    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    application
}

version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}

tasks.withType<JavaCompile>().configureEach {
    targetCompatibility = "11"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

application {
    mainClass.set("me.samoylenko.examples.vulnerable.ApplicationKt")
}
