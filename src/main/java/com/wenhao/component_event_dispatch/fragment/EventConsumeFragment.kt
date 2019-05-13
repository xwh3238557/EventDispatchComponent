package com.wenhao.component_event_dispatch.fragment

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.MotionEvent
import android.view.View
import com.wenhao.component_event_dispatch.dispatcher.BackPressedEventConsumer
import com.wenhao.component_event_dispatch.dispatcher.OnTouchEventConsumer

open class EventConsumeFragment : Fragment(), BackPressedEventConsumer, OnTouchEventConsumer {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnTouchListener { _, event -> onTouchEvent(event) }
    }

    @CallSuper
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //Mantain the root view to react the touch event
        return event?.let { e -> view?.onTouchEvent(e) } ?: false
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}