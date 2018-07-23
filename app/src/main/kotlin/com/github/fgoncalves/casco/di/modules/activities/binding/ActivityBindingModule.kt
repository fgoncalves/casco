package com.github.fgoncalves.casco.di.modules.activities.binding

import com.github.fgoncalves.casco.di.ActivityScope
import com.github.fgoncalves.casco.di.modules.activities.MainActivityModule
import com.github.fgoncalves.casco.di.modules.fragments.binding.FragmentBindingModule
import com.github.fgoncalves.casco.presentation.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        FragmentBindingModule::class])
    internal abstract fun mainActivity(): MainActivity
}
