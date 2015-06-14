package fr.ribesg.android.encypokedia.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.ribesg.android.encypokedia.Data
import fr.ribesg.android.encypokedia.activity.adapter.ListAdapter
import fr.ribesg.android.encypokedia.activity.adapter.item.ListAdapterItem
import fr.ribesg.android.encypokedia.activity.adapter.item.PokemonItem
import org.jetbrains.anko.adapter
import org.jetbrains.anko.ctx
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

/**
 * @author Ribesg
 */
class ListFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? =
        verticalLayout {
            listView {
                val list = linkedListOf<ListAdapterItem>()
                for (i in 1..721) {
                    list.add(PokemonItem(i, Data.getPkmnData(ctx, i), ctx))
                }
                adapter = ListAdapter(list)
            }
        }

}
