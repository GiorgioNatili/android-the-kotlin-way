package io.a2xe.experiments.selfielifecycle.utilities

/**
 * Created by giorgio on 3/4/18.
 */
fun notNull(vararg args: Any?, action: () -> Unit) {
    when {
        args.filterNotNull().size == args.size -> action()
    }
}