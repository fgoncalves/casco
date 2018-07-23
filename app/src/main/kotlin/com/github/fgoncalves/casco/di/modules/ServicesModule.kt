package com.github.fgoncalves.casco.di.modules

import com.github.fgoncalves.casco.data.services.FirebaseService
import com.github.fgoncalves.casco.data.services.FirebaseServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class ServicesModule {
    @Binds
    @Reusable
    abstract fun providesFirebaseService(service: FirebaseServiceImpl): FirebaseService
}
