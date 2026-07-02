plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.gradle.plugin)
}

android {
    compileSdk = 35
    namespace = "com.withplum.emojiapp"

    defaultConfig {
        applicationId = "com.withplum.emojiapp"
        minSdk = 23
        targetSdk = 35
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(project(":emojiBottomSheetDialog"))
    implementation(libs.kotlin.stdlib)
    implementation(libs.constraintlayout)
    implementation(libs.appcompat)
}
