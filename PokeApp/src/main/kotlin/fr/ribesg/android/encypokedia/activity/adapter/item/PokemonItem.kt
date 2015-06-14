package fr.ribesg.android.encypokedia.activity.adapter.item

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */
class PokemonItem(val i: Int, val pkmn: JsonObject, ctx: Context) : ListAdapterItem(ctx) {
    override val id: Long = i.toLong()
    val name = pkmn["name"].string

    override fun getView(old: View?, parent: ViewGroup): View? {
        return ctx.linearLayout {
            imageView {
                image = Data.getSprite(ctx, name)
                gravity = Gravity.CENTER_VERTICAL
                paddingRight = 5
            }.layoutParams(80, 60)
            textView {
                text = "#${i.format(3)} $name"
                textSize = 24f
                gravity = Gravity.CENTER_VERTICAL
            }
            onClick {
                ctx.toast("Selected $name!")
            }
            paddingVertical = 8
        }
    }
}
