package racingcar

import racingcar.controller.RaceController

class Application

private val raceController: RaceController = RaceConfig().raceController()

fun main() {
    with(raceController) {
        val raceStartRequest = inputForRace()

        register(raceStartRequest.carCount)

        printRaceResultTitle()

        repeat(raceStartRequest.totalRaceSet) {
            val raceResults = startRace()
            printResult(raceResults)
        }
        endRace()
    }
}
