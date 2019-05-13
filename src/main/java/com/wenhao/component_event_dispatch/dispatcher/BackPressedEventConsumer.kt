package com.wenhao.component_event_dispatch.dispatcher

interface BackPressedEventConsumer {
    fun onBackPressed(): Boolean
}