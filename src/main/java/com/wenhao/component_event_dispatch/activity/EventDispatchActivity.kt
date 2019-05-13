package com.wenhao.component_event_dispatch.activity

import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.wenhao.component_event_dispatch.manager.BackPressedEventDispatcher
import com.wenhao.component_event_dispatch.manager.BackPressedEventManager

open class EventDispatchActivity : AppCompatActivity(), BackPressedEventDispatcher {
    private val backPressedEventManager = object : BackPressedEventManager() {
        override fun onBackPressed() {
            this@EventDispatchActivity.onBackPressed();
        }

        override fun interceptBackPressedEvent(): Boolean {
            return this@EventDispatchActivity.onInterceptBackPressedEvent()
        }
    }

    override fun onInterceptBackPressedEvent() = false;

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (event.keyCode == KeyEvent.KEYCODE_BACK) {
            dispatchBackPressedEvent()
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    override fun dispatchBackPressedEvent() {
        backPressedEventManager.dispatchBackPressedEvent(supportFragmentManager)
    }
}