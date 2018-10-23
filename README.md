# Toasty
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

The usual Toast, but with steroids 💪
## Prerequisites
Add this in your root build.gradle file (not your module build.gradle file):
```gradle
allprojects {
	repositories {
		...
		maven { url  "https://dl.bintray.com/andyshon/MyRepository" }
	}
}
```
## Dependency
Add this to your module's build.gradle file (make sure the version matches the JitPack badge above):
```gradle
dependencies {
	...
	implementation 'com.andyshon.toasty:toasty:1.0.4'
}
```
## Configuration
This step is optional, but if you want you can configure some Toasty parameters. Place this anywhere in your app:
```kotlin
Toasty.Config.getInstance()
    .setErrorColor(@ColorInt errorColor: Int) // optional
    .setInfoColor(@ColorInt infoColor: Int) // optional
    .setSuccessColor(@ColorInt successColor: Int) // optional
    .setWarningColor(@ColorInt warningColor: Int) // optional
    .setTextColor(@ColorInt textColor: Int) // optional
    .tintIcon(tintIcon: Boolean) // optional (apply textColor also to the icon)
    .setGravity(@NonNull gravity: Toasty.GRAVITY) // optional
    .setToastTypeface(@NonNull typeface: Typeface) // optional
    .setTextSize(sizeInSp: Int) // optional
    .apply() // required
```
## You can reset the configuration by using reset() method:
```kotlin
Toasty.Config.reset()
```
## Usage
Each method always returns a Toast object, so you can customize the Toast much more. DON'T FORGET THE show() METHOD!
You can display an error, info, success, warning, normal and custom Toasts:
```kotlin
Toasty.normal(context, "Normal toast w/o icon").show()
Toasty.normal(context, "Normal toast w/ icon", iconDrawable).show()
Toasty.success(context, "Success!", Toast.LENGTH_SHORT, true).show()
Toasty.warning(context, "Beware of the dog.", Toast.LENGTH_SHORT, true).show()
Toasty.error(context, "This is an error toast.", Toast.LENGTH_SHORT, true).show()
Toasty.info(context, "Here is some info for you.", Toast.LENGTH_SHORT, true).show()
Toasty.custom(context, "I'm a custom Toast", iconDrawable, tintColor, duration, withIcon, 
shouldTint, Toasty.GRAVITY.RIGHT).show()
```
## Extra
You can pass formatted text to Toasty!
```kotlin
Toasty.info(context, Toasty.getFormattedMessage("prefix", "formatted text", "sufix")).show()
```
