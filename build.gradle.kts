plugins {
    kotlin("jvm") version "1.8.10"
    groovy
}

group = "bigu.kurek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")

    testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.13")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "8.0.2"
    distributionType = Wrapper.DistributionType.ALL
}
