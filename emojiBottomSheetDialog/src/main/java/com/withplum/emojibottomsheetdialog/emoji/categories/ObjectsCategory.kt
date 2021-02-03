package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.ObjectsCategoryUnicodes

data class ObjectsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<ObjectsCategoryUnicodes> = enumValues<ObjectsCategoryUnicodes>().toList()
) : Category
