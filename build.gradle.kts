import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("plugin.jpa") version "1.5.21"
}

group = "br.unipar.plano"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.11")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.12")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.5.12")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.modelmapper:modelmapper:2.4.2")
    implementation("org.modelmapper.extensions:modelmapper-spring:2.4.2")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.3.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    // https://mvnrepository.com/artifact/io.github.microutils/kotlin-logging
    implementation("io.github.microutils:kotlin-logging:2.1.21")

    // https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver
    implementation("org.mongodb:mongo-java-driver:3.12.11")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.6.7")
    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-mongodb
    implementation("org.springframework.data:spring-data-mongodb:3.3.4")


    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.5")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
