plugins {
    kotlin("jvm") version "2.2.0"
}

group = "net.bxx2004"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


kotlin {
    jvmToolchain(22)
}