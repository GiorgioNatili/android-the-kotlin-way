package io.a2xe.experiments.selfielifecycle.services

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle
import io.a2xe.experiments.selfielifecycle.utilities.noop
import io.a2xe.experiments.selfielifecycle.utilities.whenAppCompactActivity

/**
 * Created by giorgio on 2/26/18.
 */
class LifecycleObserverManager(private val lifecycleObserver: LifecycleObserver):
        Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity?) {
        activity?.noop()
    }

    override fun onActivityResumed(activity: Activity?) {
        activity?.noop()
    }

    override fun onActivityStarted(activity: Activity?) {
        activity?.noop()
    }

    override fun onActivityDestroyed(activity: Activity?) {
        activity?.let {
            it.whenAppCompactActivity {
                it.lifecycle.removeObserver(lifecycleObserver)
            }
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        activity?.noop()
    }

    override fun onActivityStopped(activity: Activity?) {
        activity?.let {
            it.whenAppCompactActivity {
                it.lifecycle.removeObserver(lifecycleObserver)
            }
        }
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        activity?.let {
            it.whenAppCompactActivity {
                it.lifecycle.addObserver(lifecycleObserver)
            }
        }
    }
}