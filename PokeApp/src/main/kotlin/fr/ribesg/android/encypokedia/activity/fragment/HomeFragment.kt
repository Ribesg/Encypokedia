package fr.ribesg.android.encypokedia.activity.fragment

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import fr.ribesg.android.encypokedia.setTextStyle
import org.jetbrains.anko.gravity
import org.jetbrains.anko.textSize
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * @author Ribesg
 */
class HomeFragment(ctx: Context) : AbstractFragment(ctx) {

    override fun createView(ctx: Context): View? = verticalLayout {
        textView("TODO") {
            textSize = 30f
            setTextStyle(Typeface.BOLD)
            gravity = Gravity.CENTER
        }
        textView("Swipe to the left!")
    }

}
