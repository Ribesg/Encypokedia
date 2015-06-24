package fr.ribesg.android.encypokedia.activity.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import fr.ribesg.android.encypokedia.activity.adapter.item.ListAdapterItem
import java.util.LinkedList

/**
 * Represents an Adapter for a ListView, designed so that the items in
 * the list decide how they're drawn.
 *
 * @author Ribesg
 */
open class ListAdapter<T : ListAdapterItem>(val listView: ListView, content: Iterable<T>? = null) : BaseAdapter() {

    /**
     * Internal List
     */
    val list: MutableList<T>

    /**
     * Visible List
     */
    val view: MutableList<T>

    /**
     * Creates the internal list and populate it with provided items.
     */
    init {
        list = LinkedList()
        if (content != null) {
            list.addAll(content)
        }
        view = LinkedList()
        view.addAll(this.list)
    }

    fun replaceList(list: List<T>) {
        view.clear()
        view.addAll(list)
        notifyDataSetChanged()
        listView.setSelection(0)
    }

    /**
     * Gets a View from the Item matched by the provided position.
     */
    override fun getView(pos: Int, old: View?, parent: ViewGroup): View? =
        getItem(pos)?.getView(old, parent)

    /**
     * Gets the Item at the provided position.
     */
    override fun getItem(pos: Int): T? =
        if (pos < view.size()) view[pos] else null

    /**
     * Gets the Item's ID at the provided position.
     */
    override fun getItemId(pos: Int): Long =
        getItem(pos)?.id ?: -1

    /**
     * Gets the Item count.
     */
    override fun getCount(): Int = view.size()

    /**
     * Specifies that IDs of Items never change.
     */
    override fun hasStableIds(): Boolean = true // TODO Check that it should not stay false

}
