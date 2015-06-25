package fr.ribesg.android.encypokedia.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import fr.ribesg.android.encypokedia.activity.adapter.FragAdapter
import fr.ribesg.android.encypokedia.activity.fragment.HomeFragment
import fr.ribesg.android.encypokedia.activity.fragment.ListFragment
import fr.ribesg.android.encypokedia.activity.fragment.PkmnFragment
import org.jetbrains.anko.adapter
import org.jetbrains.anko.id
import org.jetbrains.anko.onPageChangeListener
import org.jetbrains.anko.viewPager

/**
 * @author Ribesg
 */
class MainActivity : AppCompatActivity() {

    companion object {

        private var pkmnFrag: PkmnFragment? = null
        private var viewPager: ViewPager? = null
        private var onPkmnFragment: Boolean = false

        fun onPkmnSelected(num: Int, name: String) {
            pkmnFrag?.setPkmn(num, name)
            viewPager?.setCurrentItem(2, true)
            onPkmnFragment = true
        }

    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        pkmnFrag = PkmnFragment()

        viewPager = viewPager {
            id = 1
            adapter = FragAdapter(getSupportFragmentManager(), listOf(
                HomeFragment(),
                ListFragment(),
                pkmnFrag!!
            ))
            onPageChangeListener {
                onPageSelected {
                    onPkmnFragment = false
                }
            }
        }
        viewPager
    }

    override fun onBackPressed() {
        if (onPkmnFragment) {
            viewPager?.setCurrentItem(1)
        } else {
            super.onBackPressed()
        }
    }
}
