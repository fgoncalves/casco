package com.github.fgoncalves.casco.di.modules

import com.github.fgoncalves.casco.domain.usecases.GetColoursUseCase
import com.github.fgoncalves.casco.domain.usecases.GetColoursUseCaseImpl
import com.github.fgoncalves.casco.domain.usecases.GetLevelsUseCase
import com.github.fgoncalves.casco.domain.usecases.GetLevelsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class UseCasesModule {
    @Binds
    @Reusable
    abstract fun providesGetColoursUseCase(useCase: GetColoursUseCaseImpl): GetColoursUseCase

    @Binds
    @Reusable
    abstract fun providesGetLevelsUseCase(useCase: GetLevelsUseCaseImpl): GetLevelsUseCase
}
