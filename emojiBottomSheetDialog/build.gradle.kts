plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.gradle.plugin)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.maven.publish)
}

android {
    namespace = "com.withplum.emojibottomsheetdialog"
    compileSdk = 35
    defaultConfig {
        minSdk = 23
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
