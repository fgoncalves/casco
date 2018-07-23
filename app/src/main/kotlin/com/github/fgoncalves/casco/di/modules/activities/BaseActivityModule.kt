package com.github.fgoncalves.casco.di.modules.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.github.fgoncalves.casco.di.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule<in A : AppCompatActivity> {

    @Binds
    abstract fun activity(activity: A): AppCompatActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityContext
        fun provideContext(activity: AppCompatActivity): Context = activity
    }
}
