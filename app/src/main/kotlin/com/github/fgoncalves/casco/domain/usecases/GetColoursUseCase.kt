package com.github.fgoncalves.casco.domain.usecases

import com.github.fgoncalves.casco.data.services.FirebaseService
import io.reactivex.Single
import javax.inject.Inject

interface GetColoursUseCase : UseCase<Map<String, String>>

class GetColoursUseCaseImpl @Inject constructor(
    private val firebaseService: FirebaseService
) : GetColoursUseCase {
    override fun execute(): Single<Map<String, String>> =
        firebaseService.getRoot()
            .map { it.colours }
}
