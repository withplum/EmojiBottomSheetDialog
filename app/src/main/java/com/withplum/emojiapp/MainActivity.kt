package com.withplum.emojiapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.withplum.emojibottomsheetdialog.emoji.EmojiCategoryTransformer
import com.withplum.emojibottomsheetdialog.emoji.categories.ActivitiesCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.AnimalsNatureCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.Category
import com.withplum.emojibottomsheetdialog.emoji.categories.FlagsCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.FoodDrinkCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.ObjectsCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.SmileysPeopleCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.SymbolsCategory
import com.withplum.emojibottomsheetdialog.emoji.categories.TravelPlacesCategory
import com.withplum.emojibottomsheetdialog.view.EmojiClickListener
import com.withplum.emojibottomsheetdialog.view.EmojiPickerDialog
import com.withplum.emojibottomsheetdialog.view.recyclerview.EmojiItemView

class MainActivity : AppCompatActivity() {

    private val selectedEmoji: TextView by bind(R.id.etv_selected_emoji)
    private val selectedEmojiName: TextView by bind(R.id.tv_selected_emoji_name)
    private var emojiItemViewList: List<EmojiItemView> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeOnClickListeners()
        initializeEmojiCategoriesPreferred()
        showEmojiDialog()
    }

    private fun initializeEmojiCategoriesPreferred() {
        emojiItemViewList = EmojiCategoryTransformer().transform(initializeEmojiCategoryList())
    }

    private fun initializeOnClickListeners() {
        selectedEmoji.setOnClickListener { showEmojiDialog() }
    }

    private fun showEmojiDialog() {
        EmojiPickerDialog.Builder(this@MainActivity, emojiItemViewList)
            .dismissWithAnimation(true)
            .title(getString(com.withplum.emojibottomsheetdialog.R.string.emojiDialogTitle))
            .cancelable(true)
            .listener(object : EmojiClickListener {
                override fun emojiClicked(unicode: EmojiItemView) {
                    selectedEmoji.text = unicode.value
                    selectedEmojiName.text = unicode.name
                }
            }).build().show()
    }

    private fun initializeEmojiCategoryList(): List<Category> {
        return listOf(
            ActivitiesCategory(getString(com.withplum.emojibottomsheetdialog.R.string.activitiesCategoryTitle)),
            AnimalsNatureCategory(getString(com.withplum.emojibottomsheetdialog.R.string.animalsAndNatureTitle)),
            FoodDrinkCategory(getString(com.withplum.emojibottomsheetdialog.R.string.foodAndDrinkTitle)),
            FlagsCategory(getString(com.withplum.emojibottomsheetdialog.R.string.flagsTitle)),
            ObjectsCategory(getString(com.withplum.emojibottomsheetdialog.R.string.objectsTitle)),
            SmileysPeopleCategory(getString(com.withplum.emojibottomsheetdialog.R.string.smileysAndPeopleTitle)),
            SymbolsCategory(getString(com.withplum.emojibottomsheetdialog.R.string.symbolsTitle)),
            TravelPlacesCategory(getString(com.withplum.emojibottomsheetdialog.R.string.travelAndPlacesTitle))
        )
    }
}
