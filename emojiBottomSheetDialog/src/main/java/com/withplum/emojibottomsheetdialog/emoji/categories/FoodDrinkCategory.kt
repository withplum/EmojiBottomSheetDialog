package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.FoodDrinkCategoryUnicodes

data class FoodDrinkCategory(
    override val categoryName: String,
    override val categoryUnicode: List<FoodDrinkCategoryUnicodes> = enumValues<FoodDrinkCategoryUnicodes>().toList()
) : Category
