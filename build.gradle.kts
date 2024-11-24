plugins {
    kotlin("jvm") version "2.0.21"
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.21")

    testImplementation("org.spockframework:spock-core:2.4-M4-groovy-4.0")
    testImplementation("org.apache.groovy:groovy-all:4.0.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "8.11.1"
    distributionType = Wrapper.DistributionType.ALL
}
