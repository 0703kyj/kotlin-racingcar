package racingcar

import racingcar.controller.RaceController
import racingcar.view.InputView
import racingcar.view.ResultView

class Application

private val raceController: RaceController = RaceConfig().raceController()

fun main() {
    val carNames = InputView.inputCarNames()
    val totalRaceSet = InputView.inputTotalRaceSet()

    with(raceController) {
        register(carNames)

        ResultView.printRaceResultTitle()

        repeat(totalRaceSet) {
            val raceResults = startRace()
            ResultView.printResult(raceResults)
        }
        val winners = findWinners()
        ResultView.printWinner(winners)

        endRace()
    }
}
