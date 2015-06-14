package fr.ribesg.android.encypokedia.activity.adapter

import android.content.Context
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.activity.adapter.item.PokemonItem

/**
 * @author Ribesg
 */
class PokemonListAdapter(ctx: Context) : ListAdapter<PokemonItem>() {

    init {
        for (i in 1..721) {
            list.add(PokemonItem(i, Data.getPkmnData(ctx, i), ctx))
        }
        replaceList(list)
    }
}
