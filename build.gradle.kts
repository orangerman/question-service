plugins {
    java
    id("org.springframework.boot") version "2.6.4"
}
java{
    toolchain{
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
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.4")

}

tasks {
    test {
        useJUnitPlatform()
    }
}