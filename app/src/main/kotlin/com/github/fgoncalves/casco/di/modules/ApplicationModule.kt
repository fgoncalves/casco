package com.github.fgoncalves.casco.di.modules

import android.app.Application
import android.content.Context
import com.github.fgoncalves.casco.CascoApp
import com.github.fgoncalves.casco.di.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun application(app: CascoApp): Application

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ApplicationContext
        fun provideContext(application: Application): Context = application
    }
}
