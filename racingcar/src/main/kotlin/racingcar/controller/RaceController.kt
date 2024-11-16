package racingcar.controller

import racingcar.service.CarService
import racingcar.service.Race
import racingcar.view.InputView
import racingcar.view.ResultView
import racingcar.view.ResultView.RaceResult

class RaceController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val carService: CarService,
    private val race: Race,
) {
    fun start() {
        val raceStartRequest = inputView.inputForRace()
        carService.registerAll(raceStartRequest.carCount)

        resultView.printRaceResultTitle()
        repeat(raceStartRequest.totalRaceSet) {
            val raceResults = race().map {
                RaceResult(carId = it.carId, position = it.position)
            }
            resultView.showResult(raceResults)
        }
    }
}
