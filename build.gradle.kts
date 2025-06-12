plugins {
    id("java")
}

group = "com.ottfff"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.springframework.boot:spring-boot-starter-web:3.5.0")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.5.0")

    //test
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.27.3")
}

tasks.test {
    useJUnitPlatform()
}