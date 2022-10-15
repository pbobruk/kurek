plugins {
    kotlin("jvm") version "1.7.20"
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")

    testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.13")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.ALL
}
