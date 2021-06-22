plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.withplum.emojiapp"
        minSdkVersion(23)
        targetSdkVersion(29)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":emojiBottomSheetDialog"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:_")
    implementation("androidx.constraintlayout:constraintlayout:_")
    implementation("androidx.appcompat:appcompat:_")
}
