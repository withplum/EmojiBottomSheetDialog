buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:_")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath("com.vanniktech:gradle-maven-publish-plugin:_")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:_")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
