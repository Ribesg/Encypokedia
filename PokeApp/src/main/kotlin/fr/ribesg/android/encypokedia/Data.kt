package fr.ribesg.android.encypokedia

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.util.HashMap

/**
 * @author Ribesg
 */
object Data {

    private var data: JsonObject? = null
    fun getData(ctx: Context): JsonObject {
        if (data == null) {
            val assets = ctx.getAssets()
            val json = String(assets.open("data/pkmn/data.min.json").readBytes(), "UTF-8")
            data = JsonParser().parse(json).obj
        }
        return data!!
    }

    private var pkmnsData: JsonObject? = null
    fun getPkmnsData(ctx: Context): JsonObject {
        if (pkmnsData == null) {
            pkmnsData = getData(ctx)["pokemons"].obj
        }
        return pkmnsData!!
    }

    private val pkmnData = HashMap<Int, JsonObject>()
    fun getPkmnData(ctx: Context, num: Int): JsonObject =
        pkmnData.getOrPut(num) {
            getPkmnsData(ctx)[num.toString()].obj
        }

    private val sprites = HashMap<String, Drawable>()
    fun getSprite(ctx: Context, name: String): Drawable =
        sprites.getOrPut(name) {
            val fixedName = name.toLowerCase()
                .replace("♂", "-m")
                .replace("♀", "-f")
                .replace("'", "")
                .replace(".", "")
                .replace(' ', '-')
                .replace('é', 'e')
            val bitmap = BitmapFactory.decodeStream(
                ctx.getAssets().open("sprites/pokemon/regular/${fixedName}.png")
            )
            val bitmapDrawable = BitmapDrawable(ctx.getResources(), bitmap)
            bitmapDrawable.setAntiAlias(false)
            bitmapDrawable
        }

}
