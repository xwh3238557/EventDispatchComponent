package com.wenhao.component_event_dispatch.fragment

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.MotionEvent
import android.view.View
import com.wenhao.component_event_dispatch.manager.BackPressedEventConsumer
import com.wenhao.component_event_dispatch.manager.OnTouchEventConsumer
import com.wenhao.component_event_dispatch.manager.TouchEventManager

open class EventConsumeFragment : Fragment(), BackPressedEventConsumer, OnTouchEventConsumer {
    private val touchEventManager = TouchEventManager()

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        touchEventManager.fragment = this
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return false
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}