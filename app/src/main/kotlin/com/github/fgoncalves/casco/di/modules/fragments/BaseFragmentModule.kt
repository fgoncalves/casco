package com.github.fgoncalves.casco.di.modules.fragments

import dagger.Binds
import dagger.Module

@Module
abstract class BaseFragmentModule<in F : androidx.fragment.app.Fragment> {

    @Binds
    abstract fun fragment(fragment: F): androidx.fragment.app.Fragment
}
