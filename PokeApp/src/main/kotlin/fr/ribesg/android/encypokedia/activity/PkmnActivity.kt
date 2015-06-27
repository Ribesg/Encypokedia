package fr.ribesg.android.encypokedia.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import fr.ribesg.android.encypokedia.R
import fr.ribesg.android.encypokedia.activity.adapter.FragAdapter
import fr.ribesg.android.encypokedia.activity.fragment.PkmnPkmnFragment
import fr.ribesg.android.encypokedia.format
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * @author Ribesg
 */
class PkmnActivity : AppCompatActivity() {

    companion object {

        private var instance: PkmnActivity by Delegates.notNull()
        private var onHomeFragment: Boolean = true

    }

    private var viewPager: ViewPager by Delegates.notNull()
    private var pkmnFragment: PkmnPkmnFragment by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val num = intent.getIntExtra("num", -1)
        val name = intent.getStringExtra("name")
        assert(num != -1) {
            throw IllegalArgumentException()
        }

        instance = this

        setTitle("#${num.format(3)} - $name")
        pkmnFragment = PkmnPkmnFragment(num, name)
        viewPager = viewPager {
            id = 1
            adapter = FragAdapter(getSupportFragmentManager(), listOf(
                pkmnFragment
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
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out)
        } else {
            viewPager.currentItem = 0
        }
    }

}
