plugins {
    kotlin("jvm") version "1.6.10"
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.0")

    testImplementation("org.spockframework:spock-core:2.1-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.11")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "7.4"
    distributionType = Wrapper.DistributionType.ALL
}
