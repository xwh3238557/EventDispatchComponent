package com.wenhao.component_event_dispatch.dispatcher

interface BackPressedEventDispatcher : EventDispatcher {
    fun onInterceptBackPressedEvent(): Boolean

    fun dispatchBackPressedEvent()
}