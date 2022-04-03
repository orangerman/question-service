plugins {
    java
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.6.4")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.4")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.4")
    implementation("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    runtimeOnly("mysql:mysql-connector-java:8.0.28")
    runtimeOnly("org.flywaydb:flyway-core:7.15.0")



    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.4")
    testImplementation("org.testcontainers:testcontainers:1.16.3")
    testImplementation("org.testcontainers:mysql:1.16.3")
//    annotationProcessor("org.projectlombok:lombok:1.18.10")



}

tasks {
    test {
        useJUnitPlatform()
    }
}