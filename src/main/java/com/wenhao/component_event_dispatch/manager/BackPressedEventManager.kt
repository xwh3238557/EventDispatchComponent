package com.wenhao.component_event_dispatch.manager

import android.support.v4.app.FragmentManager

abstract class BackPressedEventManager {
    abstract fun interceptBackPressedEvent(): Boolean

    fun dispatchBackPressedEvent(fragmentManager: FragmentManager) {
        if (interceptBackPressedEvent()) {
            onBackPressed()
            return
        }

        var isEventConsumedByChildFragment = false
        fragmentManager.fragments.forEach { fragment ->
            (fragment as? BackPressedEventConsumer)?.let { consumer ->
                if (fragment.isResumed && !fragment.isDetached) {
                    // We can not return here, Because we must maintain each child fragment has a chance to receive the event
                    isEventConsumedByChildFragment = isEventConsumedByChildFragment or consumer.onBackPressed()
                }
            }
        }

        if (!isEventConsumedByChildFragment) {
            //At last the target can handle this event
            onBackPressed()
        }
    }

    abstract fun onBackPressed()
}