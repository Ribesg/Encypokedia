package fr.ribesg.android.encypokedia.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import fr.ribesg.android.encypokedia.R
import fr.ribesg.android.encypokedia.activity.adapter.PokemonListAdapter
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */
class ListFragment() : Fragment() {

    var listView: ListView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? =
        verticalLayout {
            editText {
                hintResource = R.string.filter
                textChangedListener {
                    onTextChanged { text, start, before, count ->
                        search(getText().toString())
                    }
                }
            }
            listView = listView {
                adapter = PokemonListAdapter(ctx)
                requestFocus()
            }
            listView
        }

    fun search(query: String) {
        if (listView != null) {
            val adapter = listView!!.getAdapter() as PokemonListAdapter
            val newList = try {
                query.toInt() // Throws exception if NaN
                adapter.list.filter {
                    it.i.format(3).contains(query)
                }
            } catch (e: NumberFormatException) {
                adapter.list.filter {
                    it.name.toLowerCase().contains(query.toLowerCase())
                }
            }
            adapter.replaceList(newList)
            adapter.notifyDataSetChanged()
            listView!!.setSelection(0)
        }
    }

}
