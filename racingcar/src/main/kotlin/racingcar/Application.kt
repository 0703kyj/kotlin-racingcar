package racingcar

import racingcar.controller.RaceController

class Application

private val raceController: RaceController = RaceConfig().raceController()

fun main() {
    raceController.start()
}
