package com.github.fgoncalves.casco.presentation.base

import android.os.Bundle
import androidx.core.view.GravityCompat
import com.github.fgoncalves.casco.BuildConfig
import com.github.fgoncalves.casco.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantTimber()

        setContentView(R.layout.activity_main)

        setupDrawer()
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun setupDrawer() {
        drawer?.run {
            setNavigationItemSelectedListener {
                drawer_layout?.closeDrawer(GravityCompat.START)
                it.isChecked = false
                true
            }
        }
    }
}
