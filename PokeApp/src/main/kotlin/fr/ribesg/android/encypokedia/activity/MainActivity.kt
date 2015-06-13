package fr.ribesg.android.encypokedia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import fr.ribesg.android.encypokedia.activity.adapter.FragAdapter
import fr.ribesg.android.encypokedia.activity.fragment.HomeFragment
import fr.ribesg.android.encypokedia.activity.fragment.ListFragment
import org.jetbrains.anko.adapter
import org.jetbrains.anko.id
import org.jetbrains.anko.viewPager

/**
 * @author Ribesg
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        viewPager {
            id = View.generateViewId()
            adapter = FragAdapter(getSupportFragmentManager(), listOf(
                HomeFragment(getContext()),
                ListFragment(getContext())
            ))
        }
    }

}
