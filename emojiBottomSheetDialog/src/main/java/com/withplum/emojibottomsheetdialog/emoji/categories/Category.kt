package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.CategoryUnicodes

interface Category {
    val categoryName: String
    val categoryUnicode: List<CategoryUnicodes>
}
