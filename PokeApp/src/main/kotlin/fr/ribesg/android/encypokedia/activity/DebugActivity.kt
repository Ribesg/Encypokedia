package fr.ribesg.android.encypokedia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*
import kotlin.properties.Delegates as D

class DebugActivity : AppCompatActivity() {

    val pad by D.lazy { dip(10) }

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)

        getSupportActionBar().hide()

        verticalLayout {

            paddingLeft = pad
            paddingRight = pad

            textView("Encypokedia: Debug") {
                textSize = 30f
                gravity = Gravity.CENTER
            }

            button("Main").onClick {
                startActivity<MainActivity>()
            }
        }
    }

}
