plugins {
    alias(libs.plugins.kotlin.jvm)
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.kotlin)

    testImplementation(libs.bundles.spock)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
