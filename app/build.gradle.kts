plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.gradle.plugin)
}

android {
    compileSdk = 34
    namespace = "com.withplum.emojiapp"

    defaultConfig {
        applicationId = "com.withplum.emojiapp"
        minSdk = 23
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
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

dependencies {
    implementation(project(":emojiBottomSheetDialog"))
    implementation(libs.kotlin.stdlib)
    implementation(libs.constraintlayout)
    implementation(libs.appcompat)
}
