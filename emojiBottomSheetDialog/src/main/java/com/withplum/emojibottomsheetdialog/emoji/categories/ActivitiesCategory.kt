package com.withplum.emojibottomsheetdialog.emoji.categories

import com.withplum.emojibottomsheetdialog.emoji.categoryUnicodes.ActivityCategoryUnicodes

data class ActivitiesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<ActivityCategoryUnicodes> = enumValues<ActivityCategoryUnicodes>().toList()
) : Category
