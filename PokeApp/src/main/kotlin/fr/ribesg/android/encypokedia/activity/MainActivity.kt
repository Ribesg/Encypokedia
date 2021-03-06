package fr.ribesg.android.encypokedia.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import fr.ribesg.android.encypokedia.R
import fr.ribesg.android.encypokedia.activity.adapter.FragAdapter
import fr.ribesg.android.encypokedia.activity.fragment.MainHomeFragment
import fr.ribesg.android.encypokedia.activity.fragment.MainListFragment
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * @author Ribesg
 */
class MainActivity : AppCompatActivity() {

    companion object {

        private var instance: MainActivity by Delegates.notNull()
        private var onHomeFragment: Boolean = false

        fun onPkmnSelected(num: Int, name: String) {
            val intent = Intent(instance, javaClass<PkmnActivity>())
            intent.putExtra("num", num)
            intent.putExtra("name", name)
            instance.startActivity(intent)
            instance.overridePendingTransition(R.anim.activity_in, R.anim.activity_out)
        }

    }

    private var viewPager: ViewPager by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        instance = this

        viewPager = viewPager {
            id = 1
            adapter = FragAdapter(getSupportFragmentManager(), listOf(
                MainHomeFragment(),
                MainListFragment()
            ))
            onPageChangeListener {
                onPageSelected {
                    onHomeFragment = it == 0
                }
            }
        }
    }

    override fun onBackPressed() {
        if (onHomeFragment) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = 0
        }
    }

}
