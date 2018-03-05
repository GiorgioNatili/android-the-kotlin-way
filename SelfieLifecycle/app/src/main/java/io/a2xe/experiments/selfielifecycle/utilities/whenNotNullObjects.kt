package io.a2xe.experiments.selfielifecycle.utilities

/**
 * Created by giorgio on 3/4/18.
 */
fun <T:Any> whenNotNullObjects(vararg args: T?, action: () -> Unit) {

    args.forEach {target ->
        checkNotNull(target) {
            target!!::class.java.declaredFields.forEach {
                if(it.get(target) == null) {
                    return
                }
            }
        }
    }
    action()
}
