package com.withplum.emojibottomsheetdialog.view.recyclerview

import java.nio.charset.StandardCharsets

data class EmojiItemView(val value: String, val type: EmojiItemType = EmojiItemType.EMOJI, val name: String? = null) {
    companion object {
        fun createEmojiViewItem(unicode: ByteArray, unicodeName: String): EmojiItemView {
            return EmojiItemView(unicode.toAscii(), EmojiItemType.EMOJI, unicodeName)
        }

        fun createTitleViewItem(categoryName: String): EmojiItemView {
            return EmojiItemView(categoryName, EmojiItemType.TITLE)
        }
    }
}

enum class EmojiItemType {
    TITLE,
    EMOJI
}

fun ByteArray.toAscii(): String {
    return String(this, StandardCharsets.UTF_8)
}
