package com.wenhao.component_event_dispatch.manager

import android.view.MotionEvent

interface OnTouchEventConsumer {
    fun onTouchEvent(event: MotionEvent?): Boolean
}