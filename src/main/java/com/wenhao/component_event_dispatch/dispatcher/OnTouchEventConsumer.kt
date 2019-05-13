package com.wenhao.component_event_dispatch.dispatcher

import android.view.MotionEvent

interface OnTouchEventConsumer {
    fun onTouchEvent(event: MotionEvent?): Boolean
}