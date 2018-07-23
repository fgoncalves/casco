package com.github.fgoncalves.casco.di.modules.activities

import com.github.fgoncalves.casco.di.ActivityScope
import com.github.fgoncalves.casco.di.modules.fragments.binding.FragmentBindingModule
import com.github.fgoncalves.casco.presentation.base.MainActivity
import dagger.Module
import dagger.Provides

@Module(includes = [
    FragmentBindingModule::class])
object MainActivityModule {
    @Provides
    @ActivityScope
    @JvmStatic
    fun providesFragmentManager(
        activity: MainActivity): androidx.fragment.app.FragmentManager = activity.supportFragmentManager
}
