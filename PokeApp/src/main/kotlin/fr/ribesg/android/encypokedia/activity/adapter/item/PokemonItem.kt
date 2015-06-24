package fr.ribesg.android.encypokedia.activity.adapter.item

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.activity.MainActivity
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */
class PokemonItem(val num: Int, val pkmn: JsonObject, ctx: Context) : ListAdapterItem(ctx) {
    override val id: Long = num.toLong()
    val name = pkmn["name"].string

    override fun getView(old: View?, parent: ViewGroup): View? {
        return ctx.linearLayout {
            imageView {
                image = Data.getSprite(ctx, name)
                gravity = Gravity.CENTER_VERTICAL
                paddingRight = ctx.dip(5)
            }.layoutParams {
                width = ctx.dip(60)
                height = ctx.dip(45)
            }
            textView {
                text = "#${num.format(3)} $name"
                textSize = ctx.px2dip(50)
                gravity = Gravity.CENTER_VERTICAL
            }
            onClick {
                ctx.toast("Selected $name!")
                MainActivity.onPkmnSelected(num)
            }
            paddingVertical = ctx.dip(4)
        }
    }
}
