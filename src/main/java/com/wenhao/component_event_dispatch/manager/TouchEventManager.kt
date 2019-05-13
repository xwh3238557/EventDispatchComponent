package com.wenhao.component_event_dispatch.manager

import android.support.v4.app.Fragment
import android.view.MotionEvent

class TouchEventManager {
    var fragment: Fragment? = null
        set(value) {
            if (fragment?.view == null) {
                throw IllegalArgumentException("Set this field after onCreateView. Normally in onViewCreated()")
            }

            if (fragment is OnTouchEventConsumer) {
                throw IllegalArgumentException("Fragment must implement OnTouchEventConsumer.")
            } else {
                fragment?.view?.setOnTouchListener { _, event ->
                    (fragment as? OnTouchEventConsumer)?.onTouchEvent(event) ?: false
                }
            }

            field = value
        }
}