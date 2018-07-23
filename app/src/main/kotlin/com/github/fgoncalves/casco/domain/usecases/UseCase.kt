package com.github.fgoncalves.casco.domain.usecases

import io.reactivex.Single

interface UseCase<MODEL> {
    fun execute(): Single<MODEL>
}
