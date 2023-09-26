plugins {
    kotlin("jvm") version "1.9.10"
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
    testImplementation("org.apache.groovy:groovy-all:4.0.15")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "8.3"
    distributionType = Wrapper.DistributionType.ALL
}
