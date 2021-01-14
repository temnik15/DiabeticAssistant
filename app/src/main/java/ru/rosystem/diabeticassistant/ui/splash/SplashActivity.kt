package ru.rosystem.diabeticassistant.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.rosystem.diabeticassistant.MainActivity
import ru.rosystem.diabeticassistant.ui.firstlaunch.FirstLaunchActivity

class SplashActivity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
            .splashEvent
            .observe(this) {
                when (it) {
                    SplashEvent.FIRST_LAUNCH -> {
                        val intent = Intent(this, FirstLaunchActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    SplashEvent.MAIN_LAUNCH -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        viewModel.redirect()
    }
}