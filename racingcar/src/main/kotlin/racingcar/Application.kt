package racingcar

import racingcar.controller.RaceController

class Application

private val raceController: RaceController = RaceConfig().raceController()

fun main() {
    val raceStartRequest = raceController.inputForRace()
    raceController.register(raceStartRequest.carCount)
    raceController.startRace(raceStartRequest.totalRaceSet)
    raceController.endRace()
}
