package fr.ribesg.android.encypokedia.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import fr.ribesg.android.encypokedia.activity.adapter.ListAdapter
import fr.ribesg.android.encypokedia.activity.adapter.item.ListAdapterItem
import fr.ribesg.android.encypokedia.dsl
import fr.ribesg.android.encypokedia.rand
import org.jetbrains.anko.*

/**
 * @author Ribesg
 */

class ListDemoActivity : AppCompatActivity() {

    /**
     * The last used ID for our demo items
     */
    var lastId = 0L

    /**
     * Gets the next ID and update the last ID.
     */
    fun nextId() = ++lastId

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        /**
         * Some demo item class implementing our ListAdapterItem abstract
         * class.
         *
         * It takes the ListView itself as Context to attach new dsl to
         * as well as some Strings for demonstration purpose.
         */
        class Item(ctx: Context, vararg val strings: String) : ListAdapterItem(ctx) {

            /**
             * Override and set parent class attribute to the next ID
             */
            override val id: Long = nextId()

            /**
             * We create a LinearLayout containing a TextView with our Item ID,
             * a button for each String and 3 random CheckBoxes.
             */
            override fun getView(old: View?, parent: ViewGroup): View? = ctx.dsl {
                linearLayout {

                    textView { text = "ID=" + this@Item.id }

                    for (s in strings)
                        button { text = s }

                    for (i in 1..3)
                        checkBox { checked = rand.nextBoolean() }

                }.style {
                    /*
                     * Here we style each view we created, changing the text
                     * size for example.
                     */
                    when (it) {
                        is Button   -> it.textSize = 24f
                        is TextView -> it.textSize = 32f
                    }
                }
            }
        }

        /*
         * And here we create our ListView with our ListAdapter,
         * providing a list of 3 of our items.
         */
        listView {
            adapter = ListAdapter(this,
                listOf(
                    Item(this@ListDemoActivity, "A"),
                    Item(this@ListDemoActivity, "X", "Y"),
                    Item(this@ListDemoActivity, 1.toString(), 2.toString())
                )
            )
        }
    }

}
