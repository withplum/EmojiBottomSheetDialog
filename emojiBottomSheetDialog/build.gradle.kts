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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {

    implementation(libs.kotlin.stdlib)
    implementation(libs.material)

    implementation(libs.emoji2)
    implementation(libs.emoji2.views)

    implementation(libs.recyclerview)
}
