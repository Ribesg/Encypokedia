package fr.ribesg.android.encypokedia.activity.adapter.item

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */
class PokemonItem(val i: Int, val pkmn: JsonObject, ctx: Context) : ListAdapterItem(ctx) {
    override val id: Long = i.toLong()
    val name = pkmn["name"].string
    val spriteName = name.toLowerCase()
        .replace("♂", "-m")
        .replace("♀", "-f")
        .replace("'", "")
        .replace(".", "")
        .replace(' ', '-')
        .replace('é', 'e')

    override fun getView(old: View?, parent: ViewGroup): View? {
        return ctx.linearLayout {
            imageView {
                image = Drawable.createFromStream(
                    ctx.getAssets().open("sprites/pokemon/regular/${spriteName}.png"),
                    spriteName
                )
            }.layoutParams {
                width = 40 * 2
                height = 30 * 2
            }
            textView {
                text = "#${i.format(3)} $name"
                textSize = 24f
            }
            onClick {
                ctx.toast("Selected $name!")
            }
            paddingVertical = 10
        }
    }
}
