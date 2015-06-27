package fr.ribesg.android.encypokedia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import kotlin.properties.Delegates as D

class DebugActivity : AppCompatActivity() {

    val pad by D.lazy { dip(10) }

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)

        verticalLayout {

            paddingLeft = pad
            paddingRight = pad

            button("Main").onClick {
                startActivity<MainActivity>()
            }

            button("List Demo").onClick {
                startActivity<ListDemoActivity>()
            }
        }
    }

}
