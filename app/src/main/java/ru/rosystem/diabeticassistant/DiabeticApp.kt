package ru.rosystem.diabeticassistant

import android.app.Application
import android.content.Context


class DiabeticApp : Application() {
    companion object {
        private lateinit var context: Context
        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        context = applicationContext
        super.onCreate()
    }
}