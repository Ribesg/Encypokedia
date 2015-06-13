package fr.ribesg.android.encypokedia.activity.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Ribesg
 */
abstract class AbstractFragment(val ctx: Context) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        return createView(ctx)
    }

    abstract fun createView(ctx: Context): View?

}
