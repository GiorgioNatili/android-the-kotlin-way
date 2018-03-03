package io.a2xe.experiments.selfielifecycle.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by giorgio on 2/25/18.
 */
data class LifecycleEventLog(val name: String, val component: String, val state: Any) {

    var time: String? = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))
}
