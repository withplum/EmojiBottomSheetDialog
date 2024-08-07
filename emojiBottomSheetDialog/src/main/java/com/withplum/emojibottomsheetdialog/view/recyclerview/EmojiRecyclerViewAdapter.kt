package com.withplum.emojibottomsheetdialog.view.recyclerview

import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.emoji2.widget.EmojiTextView
import androidx.recyclerview.widget.RecyclerView
import com.withplum.emojibottomsheetdialog.R

internal class EmojiRecyclerViewAdapter(
    private val unicodeList: List<EmojiItemView>
) : RecyclerView.Adapter<EmojiRecyclerViewAdapter.EmojiListHolder>() {

    class EmojiListHolder(inflatedView: View) : RecyclerView.ViewHolder(inflatedView) {
        val emojiTextView: EmojiTextView? by bind(R.id.etv_emoji)
        val textView: TextView? by bind(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiListHolder {
        return EmojiListHolder(
            when (viewType) {
                EmojiItemType.TITLE.ordinal -> {
                    val holder = LayoutInflater.from(parent.context).inflate(R.layout.row_title, parent, false)
                    holder.findViewById<TextView>(R.id.tv_title).applyHeaderTextAppearance(parent.context.theme)
                    holder
                }
                else -> {
                    LayoutInflater.from(parent.context).inflate(R.layout.row_emoji, parent, false)
                }
            }
        )
    }

    private fun TextView.applyHeaderTextAppearance(theme: Resources.Theme) {
        val typedValue = TypedValue()
        if (theme.resolveAttribute(R.attr.emojiBottomSheetSectionHeaderTextAppearance, typedValue, true)) {
            setTextAppearance(typedValue.resourceId)
        }
    }

    override fun onBindViewHolder(holder: EmojiListHolder, position: Int) {
        when (isHeader(position)) {
            true -> createTitleItem(holder, position)
            false -> createEmojiItem(holder, position)
        }
    }

    private fun createTitleItem(holder: EmojiListHolder, position: Int) {
        holder.textView?.let { it.text = getEmojiItem(position).value }
    }

    private fun createEmojiItem(holder: EmojiListHolder, position: Int) {
        holder.emojiTextView?.let { item ->
            item.apply {
                text = getEmojiItem(position).value
                setOnClickListener {
                    emojiClickedListener(getEmojiItem(position), it)
                }
            }
        }
    }

    private fun getEmojiItem(position: Int) = unicodeList[position]

    override fun getItemCount(): Int = unicodeList.size / 2

    override fun getItemViewType(position: Int) = getEmojiItem(position).type.ordinal

    fun isHeader(position: Int): Boolean = getEmojiItem(position).type.ordinal == EmojiItemType.TITLE.ordinal

    internal var emojiClickedListener: (EmojiItemView, View) -> Unit = { _, _ -> }

}
