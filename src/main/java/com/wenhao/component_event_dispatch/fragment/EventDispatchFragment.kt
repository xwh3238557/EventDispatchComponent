package com.wenhao.component_event_dispatch.fragment

import com.wenhao.component_event_dispatch.dispatcher.BackPressedEventDispatcher
import com.wenhao.component_event_dispatch.dispatcher.BackPressedEventManager

open class EventDispatchFragment : EventConsumeFragment(), BackPressedEventDispatcher {
    private val backPressedEventManager = object : BackPressedEventManager() {
        override fun interceptBackPressedEvent() = this@EventDispatchFragment.onInterceptBackPressedEvent()

        override fun onBackPressed() {
            this@EventDispatchFragment.onBackPressed()
        }
    }

    override fun onInterceptBackPressedEvent(): Boolean {
        return false
    }

    override fun dispatchBackPressedEvent() {
        backPressedEventManager.dispatchBackPressedEvent(childFragmentManager)
    }
}