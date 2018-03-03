package io.a2xe.experiments.selfielifecycle.services

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.a2xe.experiments.selfielifecycle.model.LifecycleEventLog

/**
 * Created by giorgio on 2/25/18.
 */
class LifecycleLogs : LifecycleObserver {

    private val history = arrayListOf<LifecycleEventLog>()

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {

        val log = LifecycleEventLog(event.name, owner.javaClass.canonicalName,
                owner.lifecycle.currentState)
        history.add(log)

    }

    var all: String = ""
        get() = history.joinToString("\n\n") { "${it.time} => onEvent -> ownerState: ${it.state}\nonEvent -> ownerClassName: ${it.javaClass}\nonEvent -> event: ${it.name}"}
}

