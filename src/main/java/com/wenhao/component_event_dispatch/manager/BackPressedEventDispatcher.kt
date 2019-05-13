package com.wenhao.component_event_dispatch.manager

interface BackPressedEventDispatcher : EventDispatcher {
    fun onInterceptBackPressedEvent(): Boolean

    fun dispatchBackPressedEvent()
}