plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.withplum.emojiapp"

    val javaVersion = JavaVersion.VERSION_19
    val jvm = 19

    val androidCompileSdkVersion = 34
    val androidMinSdkVersion = 23

    compileSdk = androidCompileSdkVersion

    defaultConfig {
        applicationId = "com.withplum.emojiapp"
        minSdk = androidMinSdkVersion
        targetSdk = androidCompileSdkVersion
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = "19"
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(jvm))
        }
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
