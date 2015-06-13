package fr.ribesg.android.encypokedia.activity.fragment

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.salomonbrys.kotson.obj
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import fr.ribesg.android.encypokedia.activity.adapter.ListAdapter
import fr.ribesg.android.encypokedia.activity.adapter.ListAdapterItem
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */
class ListFragment(ctx: Context) : AbstractFragment(ctx) {

    private val pkmnData: JsonObject

    init {
        pkmnData = JsonParser().parse(String(ctx.getAssets().open("data/pkmn/data.min.json").readBytes(), "UTF-8")).obj
    }

    override fun createView(ctx: Context): View? = verticalLayout {
        textView("List Fragment")
        listView {
            val list = linkedListOf<ListAdapterItem>()
            val pkmns = pkmnData["pokemons"].obj
            for (i in 1..721) {
                list.add(object : ListAdapterItem(ctx) {
                    override val id: Long = i.toLong()

                    override fun getView(old: View?, parent: ViewGroup): View? {
                        val view = TextView(ctx)
                        view.text = pkmns[i.toString()].obj["name"].string
                        return view
                    }
                })
            }
            adapter = ListAdapter(list)
        }
    }

}
