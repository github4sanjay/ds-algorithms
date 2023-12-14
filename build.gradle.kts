plugins {
    java
    jacoco
    id("io.freefair.lombok") version "8.4"
    id("com.diffplug.spotless") version "6.23.3"
    id("ai.clarity.codeartifact") version "0.0.12"
}

java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")

    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.github.stefanbirkner:system-lambda:1.2.1")
    testImplementation("org.apache.commons:commons-collections4:4.4")
}

/*val ENABLE_PREVIEW = "--enable-preview"
tasks.withType<JavaCompile> {
    options.compilerArgs.add(ENABLE_PREVIEW)
}*/

tasks.withType<Test> {
    useJUnitPlatform()
    // jvmArgs(ENABLE_PREVIEW)
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(false)
    }
}
