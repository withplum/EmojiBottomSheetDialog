package com.withplum.emojibottomsheetdialog.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.withplum.emojibottomsheetdialog.R
import com.withplum.emojibottomsheetdialog.view.recyclerview.EmojiItemView
import com.withplum.emojibottomsheetdialog.view.recyclerview.EmojiRecyclerViewAdapter

class EmojiPickerDialog(
    private val context: Context,
    private val title: String?,
    private val dismissWithAnim: Boolean,
    private val cancelable: Boolean,
    private val listener: EmojiClickListener? = null,
    private val emojiItemViewList: List<EmojiItemView>
) {
    private val bottomSheetDialog = BottomSheetDialog(context)

    private lateinit var titleTextView: TextView
    private lateinit var emojiCategoryViewContainer: LinearLayout
    private lateinit var emojiListRecyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager

    init {
        createBottomSheetDialog()
    }

    private fun createBottomSheetDialog() {
        bottomSheetDialog.apply {
            layoutInflater.inflate(R.layout.view_emoji_bottom_sheet, null).apply {
                setContentView(this)
                initializeViews(this)
            }
            title?.let { titleTextView.text = it }
            dismissWithAnimation = dismissWithAnim
            setCanceledOnTouchOutside(cancelable)
        }
    }

    private fun initializeViews(view: View) {
        emojiCategoryViewContainer = view.findViewById(R.id.ll_emoji_category_view_container)
        titleTextView = view.findViewById(R.id.tv_bottom_sheet_title)
        emojiListRecyclerView = view.findViewById(R.id.rv_emoji_category)
        attachLayoutManager()
        emojiListRecyclerView.adapter = EmojiRecyclerViewAdapter(emojiItemViewList).apply {
            emojiClickedListener = { unicode, view ->
                selectEmoji(unicode)
            }
        }
    }

    private fun attachLayoutManager() {
        gridLayoutManager = GridLayoutManager(context, 10)
        gridLayoutManager.apply {
            emojiListRecyclerView.layoutManager = this
            isSmoothScrollbarEnabled = true
            orientation = RecyclerView.VERTICAL
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if ((emojiListRecyclerView.adapter as EmojiRecyclerViewAdapter).isHeader(position)) gridLayoutManager.spanCount else 1
                }
            }
        }
    }

    fun show() {
        bottomSheetDialog.show()
    }

    private fun selectEmoji(itemView: EmojiItemView) {
        listener?.emojiClicked(itemView)
        bottomSheetDialog.dismiss()
    }

    class Builder(
        private val context: Context,
        private val emojiItemViewList: List<EmojiItemView>,
        var title: String? = null,
        var dismissWithAnimation: Boolean = true,
        var cancelable: Boolean = true,
        var listener: EmojiClickListener? = null
    ) {

        fun title(text: String) = this.apply {
            title = text
        }

        fun dismissWithAnimation(dismiss: Boolean) = this.apply {
            dismissWithAnimation = dismiss
        }

        fun cancelable(boolean: Boolean) = this.apply {
            cancelable = boolean
        }

        fun listener(emojiClickListener: EmojiClickListener) = this.apply {
            listener = emojiClickListener
        }

        fun build() = EmojiPickerDialog(
            context,
            title,
            dismissWithAnimation,
            cancelable,
            listener,
            emojiItemViewList
        )
    }
}

interface EmojiClickListener {
    fun emojiClicked(unicode: EmojiItemView)
}
