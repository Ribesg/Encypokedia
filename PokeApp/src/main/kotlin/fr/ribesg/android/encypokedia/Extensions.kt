package fr.ribesg.android.encypokedia

import android.content.Context
import android.widget.TextView

/**
 * @author Ribesg
 */

public fun TextView.setTextStyle(style: Int) {
    this.setTypeface(this.getTypeface(), style)
}

public fun Int.abs(): Int = Math.abs(this)

public inline fun <T> Context.dsl(f: Context.() -> T): T = this.let { it.f() }
