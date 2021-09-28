plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
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

    api("androidx.emoji:emoji:_")

    implementation("androidx.recyclerview:recyclerview:_")
}
