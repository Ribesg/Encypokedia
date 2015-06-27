package fr.ribesg.android.encypokedia.activity.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.ribesg.android.encypokedia.setTextStyle
import org.jetbrains.anko.gravity
import org.jetbrains.anko.textSize
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * @author Ribesg
 */
class MainHomeFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        return verticalLayout {
            textView("TODO") {
                textSize = 30f
                setTextStyle(Typeface.BOLD)
                gravity = Gravity.CENTER
            }
            textView("Swipe to the left!")
        }
    }

}
