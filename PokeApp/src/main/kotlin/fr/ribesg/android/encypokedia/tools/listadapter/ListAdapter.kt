package fr.ribesg.android.encypokedia.tools.listadapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.util.LinkedList

/**
 * Represents an Adapter for a ListView, designed so that the items in
 * the list decide how they're drawn.
 *
 * @author Ribesg
 */
class ListAdapter<T : ListAdapterItem>(content: Iterable<T>? = null) : BaseAdapter() {

    /**
     * Internal List
     */
    private val list: MutableList<T>

    /**
     * Creates the internal list and populate it with provided items.
     */
    init {
        this.list = LinkedList()
        if (content != null) {
            this.list.addAll(content)
        }
    }

    /**
     * Gets a View from the Item matched by the provided position.
     */
    override fun getView(pos: Int, old: View?, parent: ViewGroup): View? =
        this.getItem(pos)?.getView(old, parent)

    /**
     * Gets the Item at the provided position.
     */
    override fun getItem(pos: Int): T? =
        if (pos < this.list.size()) this.list[pos] else null

    /**
     * Gets the Item's ID at the provided position.
     */
    override fun getItemId(pos: Int): Long =
        this.getItem(pos)?.id ?: -1

    /**
     * Gets the Item count.
     */
    override fun getCount(): Int = this.list.size()

    /**
     * Specifies that IDs of Items never change.
     */
    override fun hasStableIds(): Boolean = true // TODO Check that it should not stay false

}
