package com.github.fgoncalves.casco.di.components

import com.github.fgoncalves.casco.CascoApp
import com.github.fgoncalves.casco.di.modules.ApplicationModule
import com.github.fgoncalves.casco.di.modules.FirebaseModule
import com.github.fgoncalves.casco.di.modules.ServicesModule
import com.github.fgoncalves.casco.di.modules.UseCasesModule
import com.github.fgoncalves.casco.di.modules.activities.binding.ActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    FirebaseModule::class,
    ServicesModule::class,
    UseCasesModule::class
])
@Singleton
interface ApplicationComponent : AndroidInjector<CascoApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CascoApp>()
}
