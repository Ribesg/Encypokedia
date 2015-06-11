package fr.ribesg.android.encypokedia.tools.listadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.text

/**
 * Represents an Item in our ListAdapter implementation.
 *
 * @author Ribesg
 */
abstract class ListAdapterItem(val ctx: Context) {

    abstract val id: Long

    open fun getView(old: View?, parent: ViewGroup): View? {
        val view = TextView(ctx)
        view.text = id.toString()
        return view
    }

}
