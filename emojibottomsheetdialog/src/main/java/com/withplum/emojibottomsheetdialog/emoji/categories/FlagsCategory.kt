package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.FlagsCategoryUnicodes

data class FlagsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<FlagsCategoryUnicodes> = enumValues<FlagsCategoryUnicodes>().toList()
) : Category
