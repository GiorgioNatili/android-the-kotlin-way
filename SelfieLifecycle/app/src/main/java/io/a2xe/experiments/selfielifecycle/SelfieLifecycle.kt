package io.a2xe.experiments.selfielifecycle

import android.app.Application
import io.a2xe.experiments.selfielifecycle.services.LifecycleLogs
import io.a2xe.experiments.selfielifecycle.services.LifecycleObserverManager
import io.a2xe.experiments.selfielifecycle.utilities.toast

/**
 * Created by giorgio on 2/25/18.
 */

class SelfieLifecycle : Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(LifecycleObserverManager(LifecycleLogs(),
                {observer -> (observer as LifecycleLogs).all.toast(this) }))
    }
}