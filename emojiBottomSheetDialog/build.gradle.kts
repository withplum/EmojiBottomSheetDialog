plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "com.withplum.emojibottomsheetdialog"

    val javaVersion = JavaVersion.VERSION_19
    val jvm = 19

    val androidCompileSdkVersion = 34
    val androidMinSdkVersion = 23

    compileSdk = androidCompileSdkVersion

    defaultConfig {
        minSdk = androidMinSdkVersion
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.material)
    implementation(libs.emoji2)
    implementation(libs.emoji2.views)
    implementation(libs.recyclerview)
}
