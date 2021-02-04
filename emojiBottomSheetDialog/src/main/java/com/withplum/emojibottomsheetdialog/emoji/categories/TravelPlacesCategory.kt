package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.TravelPlacesCategoryUnicodes

data class TravelPlacesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<TravelPlacesCategoryUnicodes> = enumValues<TravelPlacesCategoryUnicodes>().toList()
) : Category
