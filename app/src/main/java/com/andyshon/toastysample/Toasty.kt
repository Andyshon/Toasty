package com.andyshon.toastysample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.os.Build
import android.support.annotation.CheckResult
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.text.Spannable
import android.text.style.StyleSpan
import android.text.SpannableStringBuilder
import android.util.TypedValue
import android.support.annotation.StringRes

class Toasty {

    companion object {

        @ColorInt
        private var DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF")
        @ColorInt
        private var ERROR_COLOR = Color.parseColor("#D50000")
        @ColorInt
        private var INFO_COLOR = Color.parseColor("#3F51B5")
        @ColorInt
        private var SUCCESS_COLOR = Color.parseColor("#388E3C")
        @ColorInt
        private var WARNING_COLOR = Color.parseColor("#FFA900")
        @ColorInt
        private val NORMAL_COLOR = Color.parseColor("#353A3E")
        private val LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
        private var currentTypeface: Typeface? = null
        private var textSize: Int
        private var tintIcon: Boolean

        init {
            currentTypeface = LOADED_TOAST_TYPEFACE
            textSize = 16
            tintIcon = true
        }

        @CheckResult
        fun normal(context: Context, @StringRes message: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, context.getString(message), Toast.LENGTH_SHORT, null, false, position)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, message, Toast.LENGTH_SHORT, null, false, position)
        }

        @CheckResult
        fun normal(context: Context, @StringRes message: Int, icon: Drawable, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, context.getString(message), Toast.LENGTH_SHORT, icon, true, position)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, icon: Drawable, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, message, Toast.LENGTH_SHORT, icon, true, position)
        }

        @CheckResult
        fun normal(context: Context, @StringRes message: Int, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, context.getString(message), duration, null, false, position)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return normal(context, message, duration, null, false, position)
        }

        @CheckResult
        fun normal(
            context: Context, @StringRes message: Int, duration: Int,
            icon: Drawable, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return normal(context, context.getString(message), duration, icon, true, position)
        }

        @CheckResult
        fun normal(
            context: Context, message: CharSequence, duration: Int,
            icon: Drawable, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return normal(context, message, duration, icon, true, position)
        }

        @CheckResult
        fun normal(
            context: Context, @StringRes message: Int, duration: Int,
            icon: Drawable, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(context, context.getString(message), icon, NORMAL_COLOR, duration, withIcon, true, position)
        }

        @CheckResult
        fun normal(
            context: Context, message: CharSequence, duration: Int,
            icon: Drawable?, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(context, message, icon, NORMAL_COLOR, duration, withIcon, true, position)
        }

        @CheckResult
        fun warning(context: Context, @StringRes message: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return warning(context, context.getString(message), Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence, position: GRAVITY = GRAVITY.LEFT): Toast {
            return warning(context, message, Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun warning(context: Context, @StringRes message: Int, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return warning(context, context.getString(message), duration, true, position)
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int,position: GRAVITY = GRAVITY.LEFT): Toast {
            return warning(context, message, duration, true, position)
        }

        @CheckResult
        fun warning(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context,
                context.getString(message),
                getDrawable(context, R.drawable.ic_error_outline_white_48dp),
                WARNING_COLOR,
                duration,
                withIcon,
                true,
                position
            )
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, message, getDrawable(context, R.drawable.ic_error_outline_white_48dp),
                WARNING_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun info(context: Context, @StringRes message: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return info(context, context.getString(message), Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun info(context: Context, message: CharSequence, position: GRAVITY = GRAVITY.LEFT): Toast {
            return info(context, message, Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun info(context: Context, @StringRes message: Int, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return info(context, context.getString(message), duration, true, position)
        }

        @CheckResult
        fun info(context: Context, message: CharSequence, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return info(context, message, duration, true, position)
        }

        @CheckResult
        fun info(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context,
                context.getString(message),
                getDrawable(context, R.drawable.ic_info_outline_white_48dp),
                INFO_COLOR,
                duration,
                withIcon,
                true,
                position
            )
        }

        @CheckResult
        fun info(context: Context, message: CharSequence, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, message, getDrawable(context, R.drawable.ic_info_outline_white_48dp),
                INFO_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun success(context: Context, @StringRes message: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return success(context, context.getString(message), Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun success(context: Context, message: CharSequence, position: GRAVITY = GRAVITY.LEFT): Toast {
            return success(context, message, Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun success(context: Context, @StringRes message: Int, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return success(context, context.getString(message), duration, true, position)
        }

        @CheckResult
        fun success(context: Context, message: CharSequence, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return success(context, message, duration, true, position)
        }

        @CheckResult
        fun success(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, context.getString(message), getDrawable(context, R.drawable.ic_check_white_48dp),
                SUCCESS_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun success(context: Context, message: CharSequence, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, message, getDrawable(context, R.drawable.ic_check_white_48dp),
                SUCCESS_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun error(context: Context, @StringRes message: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return error(context, context.getString(message), Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun error(context: Context, message: CharSequence, position: GRAVITY = GRAVITY.LEFT): Toast {
            return error(context, message, Toast.LENGTH_SHORT, true, position)
        }

        @CheckResult
        fun error(context: Context, @StringRes message: Int, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return error(context, context.getString(message), duration, true, position)
        }

        @CheckResult
        fun error(context: Context, message: CharSequence, duration: Int, position: GRAVITY = GRAVITY.LEFT): Toast {
            return error(context, message, duration, true, position)
        }

        @CheckResult
        fun error(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, context.getString(message), getDrawable(context, R.drawable.ic_clear_white_48dp),
                ERROR_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun error(context: Context, message: CharSequence, duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT): Toast {
            return custom(
                context, message, getDrawable(context, R.drawable.ic_clear_white_48dp),
                ERROR_COLOR, duration, withIcon, true, position
            )
        }

        @CheckResult
        fun custom(
            context: Context, @StringRes message: Int, icon: Drawable,
            duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(context, context.getString(message), icon, -1, duration, withIcon, false, position)
        }

        @CheckResult
        fun custom(
            context: Context, message: CharSequence, icon: Drawable,
            duration: Int, withIcon: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(context, message, icon, -1, duration, withIcon, false, position)
        }

        @CheckResult
        fun custom(
            context: Context, @StringRes message: Int, @DrawableRes iconRes: Int,
            @ColorInt tintColor: Int, duration: Int,
            withIcon: Boolean, shouldTint: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(
                context, context.getString(message), getDrawable(context, iconRes),
                tintColor, duration, withIcon, shouldTint, position
            )
        }

        @CheckResult
        fun custom(
            context: Context, message: CharSequence, @DrawableRes iconRes: Int,
            @ColorInt tintColor: Int, duration: Int,
            withIcon: Boolean, shouldTint: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(
                context, message, getDrawable(context, iconRes),
                tintColor, duration, withIcon, shouldTint, position
            )
        }

        @CheckResult
        fun custom(
            context: Context, @StringRes message: Int, icon: Drawable,
            @ColorInt tintColor: Int, duration: Int,
            withIcon: Boolean, shouldTint: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            return custom(
                context, context.getString(message), icon, tintColor, duration,
                withIcon, shouldTint, position
            )
        }

        @SuppressLint("ShowToast")
        @CheckResult
        fun custom(
            context: Context, message: CharSequence, icon: Drawable?,
            @ColorInt tintColor: Int, duration: Int,
            withIcon: Boolean, shouldTint: Boolean, position: GRAVITY = GRAVITY.LEFT
        ): Toast {
            var icon = icon
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.toast_layout, null)
            val toastIcon: ImageView
            toastIcon = if (position == GRAVITY.LEFT) {
                toastLayout.findViewById<View>(R.id.toast_icon_left) as ImageView
            } else {
                toastLayout.findViewById<View>(R.id.toast_icon_right) as ImageView
            }
            toastIcon.visibility = View.VISIBLE
            val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
            val drawableFrame: Drawable

            if (shouldTint)
                drawableFrame = tint9PatchDrawableFrame(context, tintColor)
            else
                drawableFrame = getDrawable(context, R.drawable.toast_frame)
            setBackground(toastLayout, drawableFrame)

            if (withIcon) {
                if (icon == null)
                    throw IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true")
                if (tintIcon)
                    icon = tintIcon(icon, DEFAULT_TEXT_COLOR)
                setBackground(toastIcon, icon)
            } else {
                toastIcon.setVisibility(View.GONE)
            }

            toastTextView.text = message
            toastTextView.setTextColor(DEFAULT_TEXT_COLOR)
            toastTextView.typeface = currentTypeface
            toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())

            currentToast.view = toastLayout
            return currentToast
        }


        fun tintIcon(drawable: Drawable, @ColorInt tintColor: Int): Drawable {
            drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
            return drawable
        }

        fun tint9PatchDrawableFrame(context: Context, @ColorInt tintColor: Int): Drawable {
            val toastDrawable = getDrawable(context, R.drawable.toast_frame) as NinePatchDrawable?
            return tintIcon(toastDrawable!!, tintColor)
        }

        fun setBackground(view: View, drawable: Drawable) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.background = drawable
            } else {
                view.setBackgroundDrawable(drawable)
            }

        }

        fun getDrawable(context: Context, @DrawableRes id: Int): Drawable {
            return if (Build.VERSION.SDK_INT >= 21) context.getDrawable(id) else context.resources.getDrawable(id)
        }


        class Config private constructor() {
            @ColorInt
            private var DEFAULT_TEXT_COLOR: Int = 0
            @ColorInt
            private var ERROR_COLOR: Int = 0
            @ColorInt
            private var INFO_COLOR: Int = 0
            @ColorInt
            private var SUCCESS_COLOR: Int = 0
            @ColorInt
            private var WARNING_COLOR: Int = 0
            private var typeface: Typeface? = null
            private var textSize: Int = 0
            private var tintIcon: Boolean = false

            init {
                this.DEFAULT_TEXT_COLOR = Toasty.DEFAULT_TEXT_COLOR
                this.ERROR_COLOR = Toasty.ERROR_COLOR
                this.INFO_COLOR = Toasty.INFO_COLOR
                this.SUCCESS_COLOR = Toasty.SUCCESS_COLOR
                this.WARNING_COLOR = Toasty.WARNING_COLOR
                this.typeface = Toasty.currentTypeface
                this.textSize = Toasty.textSize
                this.tintIcon = Toasty.tintIcon
            }

            @CheckResult
            fun setTextColor(@ColorInt textColor: Int): Toasty.Companion.Config {
                this.DEFAULT_TEXT_COLOR = textColor
                return this
            }

            @CheckResult
            fun setErrorColor(@ColorInt errorColor: Int): Toasty.Companion.Config {
                this.ERROR_COLOR = errorColor
                return this
            }

            @CheckResult
            fun setInfoColor(@ColorInt infoColor: Int): Toasty.Companion.Config {
                this.INFO_COLOR = infoColor
                return this
            }

            @CheckResult
            fun setSuccessColor(@ColorInt successColor: Int): Toasty.Companion.Config {
                this.SUCCESS_COLOR = successColor
                return this
            }

            @CheckResult
            fun setWarningColor(@ColorInt warningColor: Int): Toasty.Companion.Config {
                this.WARNING_COLOR = warningColor
                return this
            }

            @CheckResult
            fun setToastTypeface(typeface: Typeface): Toasty.Companion.Config {
                this.typeface = typeface
                return this
            }

            @CheckResult
            fun setTextSize(sizeInSp: Int): Toasty.Companion.Config {
                this.textSize = sizeInSp
                return this
            }

            @CheckResult
            fun tintIcon(tintIcon: Boolean): Toasty.Companion.Config {
                this.tintIcon = tintIcon
                return this
            }

            fun apply() {
                Toasty.DEFAULT_TEXT_COLOR = this.DEFAULT_TEXT_COLOR
                Toasty.ERROR_COLOR = this.ERROR_COLOR
                Toasty.INFO_COLOR = this.INFO_COLOR
                Toasty.SUCCESS_COLOR = this.SUCCESS_COLOR
                Toasty.WARNING_COLOR = this.WARNING_COLOR
                Toasty.currentTypeface = this.typeface
                Toasty.textSize = this.textSize
                Toasty.tintIcon = this.tintIcon
            }

            companion object {

                val instance: Toasty.Companion.Config
                    @CheckResult
                    get() = Toasty.Companion.Config()

                fun reset() {
                    Toasty.DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF")
                    Toasty.ERROR_COLOR = Color.parseColor("#D50000")
                    Toasty.INFO_COLOR = Color.parseColor("#3F51B5")
                    Toasty.SUCCESS_COLOR = Color.parseColor("#388E3C")
                    Toasty.WARNING_COLOR = Color.parseColor("#FFA900")
                    Toasty.currentTypeface = Toasty.LOADED_TOAST_TYPEFACE
                    Toasty.textSize = 16
                    Toasty.tintIcon = true
                }
            }
        }


        fun getFormattedMessage(before: String = "", formattedText: String = "Toast", after: String = "", style: STYLE = STYLE.NORMAL): CharSequence {
            val ssb = SpannableStringBuilder(before).append(formattedText).append(after)
            val prefixLen = before.length
            ssb.setSpan(
                StyleSpan(style.value),
                prefixLen, prefixLen + formattedText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return ssb
        }
    }

    enum class STYLE constructor(val value:Int) {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3)
    }

    enum class GRAVITY constructor(val position: Int) {
        LEFT(0),
        RIGHT(1)
    }
}