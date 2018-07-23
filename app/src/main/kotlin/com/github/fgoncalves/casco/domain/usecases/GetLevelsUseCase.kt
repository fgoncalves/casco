package com.github.fgoncalves.casco.domain.usecases

import com.github.fgoncalves.casco.data.models.Level
import com.github.fgoncalves.casco.data.services.FirebaseService
import io.reactivex.Single
import javax.inject.Inject

interface GetLevelsUseCase : UseCase<List<Level>>

class GetLevelsUseCaseImpl @Inject constructor(
    private val firebaseService: FirebaseService
) : GetLevelsUseCase {
    override fun execute(): Single<List<Level>> =
        firebaseService.getRoot()
            .map { it.levels }
            .map(this::shuffleExerciseAnswers)

    private fun shuffleExerciseAnswers(levels: List<Level>) =
        levels.map {
            it.copy(exercises = it.exercises.map {
                it.copy(colours = it.colours.shuffled())
            })
        }
}
