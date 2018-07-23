package com.github.fgoncalves.casco.di.modules.fragments.binding

import com.github.fgoncalves.casco.di.ScreenScope
import com.github.fgoncalves.casco.di.modules.fragments.HomeFragmentModule
import com.github.fgoncalves.casco.presentation.home.HomeScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ScreenScope
    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class])
    internal abstract fun contributesHomeScreen(): HomeScreen
}
