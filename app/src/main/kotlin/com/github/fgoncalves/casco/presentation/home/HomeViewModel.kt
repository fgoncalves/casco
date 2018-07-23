package com.github.fgoncalves.casco.presentation.home

import android.graphics.Color
import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.github.fgoncalves.casco.R
import com.github.fgoncalves.casco.config.DEFAULT_TIME
import com.github.fgoncalves.casco.domain.usecases.GetColoursUseCase
import com.github.fgoncalves.casco.domain.usecases.GetLevelsUseCase
import com.github.fgoncalves.casco.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Singles
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit
import javax.inject.Inject

abstract class HomeViewModel : BaseViewModel() {
    abstract val progressBarVisibilityChangeListener: ObservableInt

    abstract val contentVisibility: ObservableInt

    abstract val timeLeft: ObservableInt

    abstract val totalTime: ObservableInt

    abstract val colour: ObservableField<String>

    abstract val topLeftColour: ObservableInt

    abstract val topRightColour: ObservableInt

    abstract val bottomLeftColour: ObservableInt

    abstract val bottomRightColour: ObservableInt
}

class HomeViewModelImpl @Inject constructor(
    private val getLevelsUseCase: GetLevelsUseCase,
    private val getColoursUseCase: GetColoursUseCase
) : HomeViewModel() {
    private val disposables = CompositeDisposable()

    override val progressBarVisibilityChangeListener = ObservableInt(View.VISIBLE)
    override val contentVisibility = ObservableInt(View.GONE)
    override val timeLeft = ObservableInt(1)
    override val totalTime = ObservableInt(1)
    override val colour = ObservableField<String>("")
    override val topLeftColour = ObservableInt(0)
    override val topRightColour = ObservableInt(0)
    override val bottomLeftColour = ObservableInt(0)
    override val bottomRightColour = ObservableInt(0)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        progressBarVisibilityChangeListener.set(View.VISIBLE)
        Singles.zip(
            getLevelsUseCase.execute(),
            getColoursUseCase.execute()) { levels, colours ->
            Pair(levels, colours)
        }
            .doOnSubscribe { disposables.add(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { (levels, colours) ->
                    progressBarVisibilityChangeListener.set(View.GONE)
                    contentVisibility.set(View.VISIBLE)

                    kickOffTimer(levels[0].speed)

                    val exercise = levels[0].exercises[0]
                    topLeftColour.set(colours[exercise.colours[0].id]?.asColour() ?: R.color.beige)
                    topRightColour.set(colours[exercise.colours[1].id]?.asColour() ?: R.color.beige)
                    bottomLeftColour.set(colours[exercise.colours[2].id]?.asColour() ?: R.color.beige)
                    bottomRightColour.set(colours[exercise.colours[3].id]?.asColour() ?: R.color.beige)

                    colour.set(exercise.correct)
                }
            )
    }

    private fun kickOffTimer(speed: Int) {
        val time = (DEFAULT_TIME / speed) * 1000

        totalTime.set(time)
        timeLeft.set(time)

        val factor = 100L
        Observable.interval(factor, TimeUnit.MILLISECONDS)
            .take(time.toLong() / factor)
            .doOnSubscribe { disposables.add(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    val newTime = totalTime.get() - it.toInt() * 100
                    timeLeft.set(newTime)
                },

                onComplete = { timeLeft.set(0) }
            )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        disposables.clear()
    }

    private fun String.asColour() = Color.parseColor(this)
}
