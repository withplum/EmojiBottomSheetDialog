pluginManagement {
    repositories {
        google()
        mavenCentral()
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
