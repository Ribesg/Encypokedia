package fr.ribesg.android.encypokedia.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.activity.MainActivity
import fr.ribesg.android.encypokedia.dsl
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * @author Ribesg
 */
class PkmnFragment() : Fragment() {

    var imageView: ImageView by Delegates.notNull()
    var numTextView: TextView by Delegates.notNull()
    var nameTextView: TextView by Delegates.notNull()
    var descTextView: TextView by Delegates.notNull()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? = ctx.dsl {
        relativeLayout {
            frameLayout {
                id = 1
                imageView = imageView().layoutParams {
                    gravity = Gravity.CENTER
                }
            }.layoutParams {
                width = dip(235)
                height = dip(190)
                margin = dip(1)
                alignParentTop()
                alignParentLeft()
            }
            numTextView = textView {
                id = 2
            }.layoutParams {
                rightOf(1)
            }
            nameTextView = textView {
                id = 3
            }.layoutParams {
                rightOf(1)
                below(2)
            }
            descTextView = textView {
                id = 4
            }.layoutParams {
                alignParentLeft()
                below(1)
            }

            gravity = Gravity.TOP
        }
    }

    fun setPkmn(num: Int, name: String) {
        val gif = Data.getGif(ctx.getAssets(), num)
        imageView.getLayoutParams().width = dip(gif.getIntrinsicWidth())
        imageView.getLayoutParams().height = dip(gif.getIntrinsicHeight())
        imageView.image = gif

        numTextView.text = '#' + num.toString()
        nameTextView.text = name
        descTextView.text = "// TODO Description should be here"
    }

}
