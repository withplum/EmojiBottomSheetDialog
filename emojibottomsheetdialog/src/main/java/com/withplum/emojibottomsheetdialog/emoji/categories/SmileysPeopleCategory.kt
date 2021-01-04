package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.SmileysPeopleCategoryUnicodes

data class SmileysPeopleCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SmileysPeopleCategoryUnicodes> = enumValues<SmileysPeopleCategoryUnicodes>().toList()
) : Category
