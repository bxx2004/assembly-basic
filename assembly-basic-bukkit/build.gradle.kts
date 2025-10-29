import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.izzel.taboolib.gradle.*
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8


plugins {
    java
    id("io.izzel.taboolib") version "2.0.27"
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
}

taboolib {
    env {
        install(BukkitUtil)
        install(Bukkit)
        install(Basic)
        install(BukkitHook)
    }
    description {
        name = "assembly-basic-bukkit"
        contributors {
            name("12232")
        }
        dependencies{
            name("assembly-bukkit").optional(false)
        }
    }
    version { taboolib = "6.2.3-664550e" }
}

repositories {
    mavenCentral()
    maven {
        url = uri("http://mavenrepo.revoist.cn/repository/maven-releases/")
        isAllowInsecureProtocol = true
    }
}

dependencies {
    compileOnly("ink.ptms.core:v12004:12004:mapped")
    compileOnly("ink.ptms.core:v12004:12004:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
    compileOnly("net.bxx2004:assembly-bukkit-api:1.2.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JVM_1_8)
        freeCompilerArgs.add("-Xjvm-default=all")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}