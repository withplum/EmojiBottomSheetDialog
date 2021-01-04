package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.SymbolsCategoryUnicodes

data class SymbolsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SymbolsCategoryUnicodes> = enumValues<SymbolsCategoryUnicodes>().toList()
) : Category
