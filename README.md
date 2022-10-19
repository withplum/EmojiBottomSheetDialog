[![Maven Central](https://img.shields.io/maven-central/v/com.withplum/emojiBottomSheetDialog.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.withplum%22%20AND%20a:%22emojiBottomSheetDialog%22)
# EmojiBottomSheetDialog
A nice Android bottom sheet dialog populated with AndroidX EmojiCompat supported emojis.

![EmojiBottomSheetDialog gif](https://i.imgur.com/0GisGjI.gif)

## Usage

```kotlin

    private fun initializeEmojiCategoriesPreferred() {
        emojiItemViewList = EmojiCategoryTransformer().transform(initializeEmojiCategoryList())
    }

    private fun initializeEmojiCategoryList(): List<Category> {
        return listOf(
            ActivitiesCategory(getString(R.string.activitiesCategoryTitle)),
            AnimalsNatureCategory(getString(R.string.animalsAndNatureTitle)),
            FoodDrinkCategory(getString(R.string.foodAndDrinkTitle)),
            FlagsCategory(getString(R.string.flagsTitle)),
            ObjectsCategory(getString(R.string.objectsTitle)),
            SmileysPeopleCategory(getString(R.string.smileysAndPeopleTitle)),
            SymbolsCategory(getString(R.string.symbolsTitle)),
            TravelPlacesCategory(getString(R.string.travelAndPlacesTitle))
        )
    }

    private fun showEmojiDialog() {
        EmojiPickerDialog.Builder(this@MainActivity, emojiItemViewList)
            .dismissWithAnimation(true)
            .title(getString(R.string.emojiDialogTitle))
            .cancelable(true)
            .listener(object : EmojiClickListener {
                override fun emojiClicked(unicode: EmojiItemView) {
                    selectedEmoji.text = unicode.value
                    selectedEmojiName.text = unicode.name
                }
            }).build().show()
    }
```

## Breaking changes of version `2.0.0`
In version `2.0.0` we migrated to [Emoji2](https://developer.android.com/jetpack/androidx/releases/emoji2).
This results in the removal of:
* `EmojiCompatUtils`
* `EmojInitListener`
* `EmojiValues` which was mostly used internally.

Initialization now happens internally via the [Emoji2](https://developer.android.com/jetpack/androidx/releases/emoji2).
If you still need an initialization listener you should use the official API as described [here](https://developer.android.com/develop/ui/views/text-and-emoji/emoji2#add-initialization-listeners).
The whole document [Support modern emoji - Android Developers](https://developer.android.com/develop/ui/views/text-and-emoji/emoji2) provides further details.

The same document will help you if you rely on AppCompat version lower than `1.4.0-alpha01` or on the [Emoji](https://developer.android.com/jetpack/androidx/releases/emoji)
library itself which provides [these custom views](https://developer.android.com/reference/kotlin/androidx/emoji/widget/package-summary) for compatibility.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

### Publishing
The project uses [gradle-maven-publish-plugin](https://github.com/vanniktech/gradle-maven-publish-plugin) to publish artifacts to maven central.

To upload archives use the command (after having put the appropriate credentials in gradle properties or env variables):

```
./gradlew clean build emojiBottomSheetDialog:publish --no-daemon --no-parallel
```
