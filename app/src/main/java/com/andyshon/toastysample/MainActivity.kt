package com.andyshon.toastysample

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andyshon.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toasty.Config.instance
            .setErrorColor(resources.getColor(R.color.colorAccent)) // optional
            .setInfoColor(resources.getColor(R.color.colorAccent)) // optional
            .setSuccessColor(resources.getColor(R.color.colorAccent)) // optional
            .setWarningColor(resources.getColor(R.color.colorAccent)) // optional
            .setTextColor(resources.getColor(R.color.colorAccent)) // optional
            .tintIcon(true) // optional (apply textColor also to the icon)
            .setGravity(Toasty.GRAVITY.RIGHT)
            .setToastTypeface(Typeface.DEFAULT) // optional
            .setTextSize(30) // optional

            .apply(); // required


        button_error_toast.setOnClickListener {
            Toasty.error(this, R.string.error_message, Toast.LENGTH_SHORT, true, Toasty.GRAVITY.RIGHT).show()
        }
        
        
        button_success_toast.setOnClickListener {
            Toasty.success(this, R.string.success_message, Toast.LENGTH_SHORT, true, Toasty.GRAVITY.LEFT).show()
        }

        button_info_toast.setOnClickListener {
            Toasty.info(this, R.string.info_message, Toast.LENGTH_SHORT, true, Toasty.GRAVITY.RIGHT).show()
        }
        
        button_warning_toast.setOnClickListener {
            Toasty.warning(this, R.string.warning_message, Toast.LENGTH_SHORT, true, Toasty.GRAVITY.RIGHT).show()
        }

        button_normal_toast_wo_icon.setOnClickListener {
            Toasty.normal(this, R.string.normal_message_without_icon, Toast.LENGTH_LONG, Toasty.GRAVITY.RIGHT).show()
        }
        
        button_normal_toast_w_icon.setOnClickListener {
            val icon = resources.getDrawable(R.drawable.ic_pets_white_48dp)
            Toasty.normal(this, R.string.normal_message_with_icon, icon, Toasty.GRAVITY.RIGHT).show()
        }

        button_info_toast_with_formatting.setOnClickListener {
            Toasty.info(this, Toasty.getFormattedMessage("before", "that formatted text", "after")).show()

            Toasty.custom(this@MainActivity, "I'm a custom Toast", resources.getDrawable(R.drawable.ic_check_white_48dp), resources.getColor(Color.GREEN),
                Toast.LENGTH_LONG, true, true, Toasty.GRAVITY.RIGHT).show()
        }

        button_custom_config.setOnClickListener {
                Toasty.Config.instance
                    .setTextColor(Color.GREEN)
                    .setToastTypeface(Typeface.createFromAsset(assets, "PCap Terminal.otf"))
                    .apply()
                Toasty.custom(this, R.string.custom_message, resources.getDrawable(R.drawable.akka_lenya),
                    Color.BLACK, Toast.LENGTH_LONG, true, true, Toasty.GRAVITY.RIGHT).show()
                Toasty.Config.reset() // Use this if you want to use the configuration above only once
            }
    }
}


