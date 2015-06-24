package fr.ribesg.android.encypokedia.activity.adapter

import android.widget.ListView
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.activity.adapter.item.PokemonItem

/**
 * @author Ribesg
 */
class PokemonListAdapter(listView: ListView) : ListAdapter<PokemonItem>(listView) {

    init {
        for (i in 1..721) {
            list.add(PokemonItem(i, Data.getPkmnData(listView.getContext(), i), listView.getContext()))
        }
        replaceList(list)
    }
}
