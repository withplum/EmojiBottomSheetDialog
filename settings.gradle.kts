pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

include(":emojiBottomSheetDialog", ":app")
rootProject.name = "EmojiBottomSheetDialog"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
