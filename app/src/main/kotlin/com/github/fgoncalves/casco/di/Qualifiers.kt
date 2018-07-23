package com.github.fgoncalves.casco.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ChildFragmentManager

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext
