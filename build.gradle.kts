
plugins {
    id ("java-library")
    id ("maven-publish")
    id ("io.spring.dependency-management") version "1.1.7"
}

group = "com.hazelcast"
version = "4.0.1"
description = "Spring Data Hazelcast"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.spring.io/libs-snapshot")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("org.slf4j:slf4j-api:2.0.17")
    api("org.springframework.data:spring-data-keyvalue:4.0.1")
    api("org.springframework.data:spring-data-commons:4.0.1")
    api("com.hazelcast:hazelcast:5.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:6.0.2")
    testImplementation("org.mockito:mockito-core:5.21.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.21.0")
    testImplementation("org.assertj:assertj-core:4.0.0-M1")
    testImplementation("org.springframework:spring-test:7.0.2")
    testImplementation("ch.qos.logback:logback-classic:1.5.24")
    testImplementation("org.projectlombok:lombok:1.18.42")
    testImplementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    testImplementation("org.hamcrest:hamcrest:3.0")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
