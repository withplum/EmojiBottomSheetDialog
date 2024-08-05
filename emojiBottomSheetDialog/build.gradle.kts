plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "com.withplum.emojibottomsheetdialog"
    compileSdk = 34
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

    implementation("org.jetbrains.kotlin:kotlin-stdlib:_")
    implementation("com.google.android.material:material:_")

    implementation("androidx.emoji2:emoji2:_")
    implementation("androidx.emoji2:emoji2-views:_")

    implementation("androidx.recyclerview:recyclerview:_")
}
