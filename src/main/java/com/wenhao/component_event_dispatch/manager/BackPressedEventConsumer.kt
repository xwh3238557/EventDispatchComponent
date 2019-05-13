package com.wenhao.component_event_dispatch.manager

interface BackPressedEventConsumer {
    fun onBackPressed(): Boolean
}