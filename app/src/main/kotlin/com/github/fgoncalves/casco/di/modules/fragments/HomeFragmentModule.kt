package com.github.fgoncalves.casco.di.modules.fragments

import androidx.lifecycle.ViewModel
import com.github.fgoncalves.casco.di.ChildFragmentManager
import com.github.fgoncalves.casco.di.keys.ViewModelKey
import com.github.fgoncalves.casco.presentation.home.HomeScreen
import com.github.fgoncalves.casco.presentation.home.HomeViewModel
import com.github.fgoncalves.casco.presentation.home.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule : BaseFragmentModule<HomeScreen>() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ChildFragmentManager
        fun providesChildFragmentPageAdapter(fragment: HomeScreen): androidx.fragment.app.FragmentManager = fragment.childFragmentManager
    }

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun providesHomeViewModel(viewModel: HomeViewModelImpl): ViewModel
}
