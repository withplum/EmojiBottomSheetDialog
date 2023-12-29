buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath(libs.gradle)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.gradle.maven.publish.plugin)
        classpath(libs.dokka.gradle.plugin)
    }
}
