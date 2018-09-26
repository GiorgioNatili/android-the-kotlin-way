import android.view.View

fun View.visibleOrInvisible(visible: Boolean) {
    visibility = if(visible) View.VISIBLE else View.GONE
}