package com.withplum.emojibottomsheetdialog.emoji

import android.content.Context
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import com.withplum.emojibottomsheetdialog.R

object EmojiCompatUtils {

    private var emojiCompat: EmojiCompat? = null

    fun initialize(context: Context, emojiListener: EmojInitListener) {
        emojiCompat = EmojiCompat.init(FontRequestEmojiCompatConfig(context, createFontRequest()).apply {
            setReplaceAll(true)
            registerInitCallback(InitCallback(emojiListener))
        })
    }

    private fun createFontRequest(): FontRequest = FontRequest(
        PROVIDE_AUTHORITY_FONT,
        PROVIDE_PACKAGE_FONT,
        QUERY_FONT,
        R.array.com_google_android_gms_fonts_certs
    )

    fun hasEmojiGlyph(unicodeString: String): Boolean {
        return emojiCompat?.hasEmojiGlyph(unicodeString) ?: false
    }

    private class InitCallback internal constructor(private val listener: EmojInitListener) : EmojiCompat.InitCallback() {

        override fun onInitialized() {
            listener.onEmojisInitialized()
        }

        override fun onFailed(throwable: Throwable?) {
            super.onFailed(throwable)
            listener.onEmojisInitializedError()
        }
    }
}

