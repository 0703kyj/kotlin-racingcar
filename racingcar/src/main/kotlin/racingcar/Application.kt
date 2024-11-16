package racingcar

import racingcar.controller.RaceController
import racingcar.view.InputView
import racingcar.view.ResultView

class Application

private val raceController: RaceController = RaceConfig().raceController()

fun main() {
    val carCount = InputView.inputCarCount()
    val totalRaceSet = InputView.inputTotalRaceSet()

    with(raceController) {
        register(carCount)

        ResultView.printRaceResultTitle()

        repeat(totalRaceSet) {
            val raceResults = startRace()
            ResultView.printResult(raceResults)
        }
        endRace()
    }
}
