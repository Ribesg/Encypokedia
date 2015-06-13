package fr.ribesg.android.encypokedia.activity.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author Ribesg
 */
class FragAdapter(fm: FragmentManager, fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

    private val fragments = fragments.toList() // Makes a copy

    override fun getItem(i: Int): Fragment? = fragments.get(i)

    override fun getCount(): Int = fragments.size()

}
