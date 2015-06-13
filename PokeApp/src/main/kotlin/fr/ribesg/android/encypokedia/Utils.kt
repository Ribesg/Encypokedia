package fr.ribesg.android.encypokedia


import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Ribesg
 */
object ViewUtils {

    val sNextGeneratedId: AtomicInteger = AtomicInteger(1);

    /**
     * Generate a value suitable for use in {@link #setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    fun generateViewId(): Int {
        while (true) {
            val res = sNextGeneratedId.get();
            var newValue = res + 1;
            if (newValue > 0x00FFFFFF) newValue = 1;
            if (sNextGeneratedId.compareAndSet(res, newValue)) {
                return res;
            }
        }
    }

}
