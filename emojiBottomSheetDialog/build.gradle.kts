plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 23
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
