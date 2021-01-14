package ru.rosystem.diabeticassistant.ui.splash

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.rosystem.diabeticassistant.AppData
import ru.rosystem.diabeticassistant.BuildConfig
import ru.rosystem.diabeticassistant.DiabeticApp

class SplashViewModel : ViewModel() {
    private val _splashEvent = MutableLiveData<SplashEvent>()
    val splashEvent: LiveData<SplashEvent>
        get() = _splashEvent

    private val NO_INSTALL_VERSION = -1


    fun redirect() {
        val pref = DiabeticApp.getContext()
            .getSharedPreferences(AppData.KEY_LAUNCH_SHARED_PREF, Context.MODE_PRIVATE)
        val version = pref.getInt(AppData.KEY_VERSION_PREF, NO_INSTALL_VERSION)
        if (version<BuildConfig.INSTALL_VERSION) {
            _splashEvent.value = SplashEvent.FIRST_LAUNCH
            saveVersionToSharedPref(pref)
        } else {
            _splashEvent.value = SplashEvent.MAIN_LAUNCH
        }
    }

    private fun saveVersionToSharedPref(pref: SharedPreferences) {
        val editor = pref.edit()
        editor.putInt(AppData.KEY_VERSION_PREF, BuildConfig.VERSION_CODE)
        editor.apply()
    }

}