package com.github.fgoncalves.casco.di.modules

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class FirebaseModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Reusable
        fun providesFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
    }
}
