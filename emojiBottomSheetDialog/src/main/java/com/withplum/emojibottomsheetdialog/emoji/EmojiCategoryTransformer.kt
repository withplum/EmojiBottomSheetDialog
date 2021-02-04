package com.withplum.emojibottomsheetdialog.emoji

import com.withplum.emojibottomsheetdialog.emoji.categories.Category
import com.withplum.emojibottomsheetdialog.view.recyclerview.EmojiItemType
import com.withplum.emojibottomsheetdialog.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(categoryList: List<Category>): List<EmojiItemView> = transformCategoriesToEmojiItems(categoryList).filter {
        it.type == EmojiItemType.TITLE || EmojiCompatUtils.hasEmojiGlyph(it.value)
    }

    private fun transformCategoriesToEmojiItems(createEmojiList: List<Category>): List<EmojiItemView> {
        val list: MutableList<EmojiItemView> = mutableListOf()
        createEmojiList.map { category ->
            list.add(EmojiItemView.createTitleViewItem(category.categoryName))
            list.apply {
                category.categoryUnicode.forEach {
                    list.add(EmojiItemView.createEmojiViewItem(it.unicode, it.name))
                }
            }
        }
        return list
    }
}
