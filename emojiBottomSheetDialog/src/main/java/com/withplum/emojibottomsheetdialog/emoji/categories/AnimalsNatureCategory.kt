package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.AnimalsNatureCategoryUnicodes

data class AnimalsNatureCategory(
    override val categoryName: String,
    override val categoryUnicode: List<AnimalsNatureCategoryUnicodes> = enumValues<AnimalsNatureCategoryUnicodes>().toList()
) : Category
