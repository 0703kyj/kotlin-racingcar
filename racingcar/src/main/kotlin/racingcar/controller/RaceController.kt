package racingcar.controller

import racingcar.view.InputView
import racingcar.view.ResultView

class RaceController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun start() {
        val raceStartRequest = inputView.inputForRace()

        resultView.showResult(raceStartRequest.totalRaceSet, emptyList())
    }
}
