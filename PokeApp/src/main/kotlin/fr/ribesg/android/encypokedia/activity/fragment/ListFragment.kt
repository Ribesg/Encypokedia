package fr.ribesg.android.encypokedia.activity.fragment

import android.content.Context
import android.view.View
import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import fr.ribesg.android.encypokedia.activity.adapter.ListAdapter
import fr.ribesg.android.encypokedia.activity.adapter.item.ListAdapterItem
import fr.ribesg.android.encypokedia.activity.adapter.item.PokemonItem
import org.jetbrains.anko.adapter
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

/**
 * @author Ribesg
 */
class ListFragment(ctx: Context) : AbstractFragment(ctx) {

    private val pkmnData: JsonObject

    init {
        pkmnData = JsonParser().parse(String(ctx.getAssets().open("data/pkmn/data.min.json").readBytes(), "UTF-8")).obj
    }

    override fun createView(ctx: Context): View? = verticalLayout {
        listView {
            val list = linkedListOf<ListAdapterItem>()
            val pkmns = pkmnData["pokemons"].obj
            for (i in 1..721) {
                list.add(PokemonItem(i, pkmns[i.toString()].obj, ctx))
            }
            adapter = ListAdapter(list)
        }
    }

}
