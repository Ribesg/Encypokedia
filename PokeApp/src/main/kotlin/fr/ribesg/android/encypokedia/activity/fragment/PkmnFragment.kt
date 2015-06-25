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

    var imageView: ImageView? = null
    var numTextView: TextView? = null
    var nameTextView: TextView? = null
    var descTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? =
        verticalLayout {
            linearLayout {
                linearLayout {
                    imageView = imageView {

                    }
                    imageView

                    gravity = Gravity.CENTER
                }.layoutParams {
                    width = dip(175)
                    height = dip(175)
                    margin = dip(5)
                }
                verticalLayout {
                    numTextView = textView()
                    numTextView
                    nameTextView = textView()
                    nameTextView
                }
            }
            descTextView = textView()
        }

    fun setPkmn(num: Int, name: String) {
        val gif = GifDrawable(ctx.getAssets(), "animated-sprites/" + num.format(3) + ".gif")
        imageView!!.layoutParams!!.width = gif.getIntrinsicWidth() * 2
        imageView!!.layoutParams!!.height = gif.getIntrinsicHeight() * 2
        imageView!!.image = gif

        numTextView!!.text = '#' + num.toString()
        nameTextView!!.text = name
        descTextView!!.text = "// TODO Description should be here"
    }

}
