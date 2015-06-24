package fr.ribesg.android.encypokedia.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*
import pl.droidsonroids.gif.GifDrawable

/**
 * @author Ribesg
 */
class PkmnFragment() : Fragment() {

    var textView: TextView? = null
    var imageView: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? =
        verticalLayout {
            textView = textView()
            imageView = imageView {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                setAdjustViewBounds(true)
            }.layoutParams {
                width = dip(125)
                height = dip(125)
            }

            textView
            imageView

            gravity = Gravity.CENTER_VERTICAL
        }

    fun setPkmn(num: Int) {
        textView?.text = num.toString()
        imageView?.image = GifDrawable(ctx.getAssets(), "animated-sprites/" + num.format(3) + ".gif")
    }

}
