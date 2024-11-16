package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.car.CarService
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
    fun inputForRace(): RaceStartRequest {
        val carCount = inputView.inputCarCount()
        val totalRaceSet = inputView.inputTotalRaceSet()

        return RaceStartRequest(carCount = carCount, totalRaceSet = totalRaceSet)
    }

    fun register(carCount: Int) = carService.registerAll(carCount)

    fun startRace(): List<RaceResult> = race().toRaceResult()

    fun endRace() = carService.clear()

    fun printRaceResultTitle() = resultView.printRaceResultTitle()

    fun printResult(raceResults: List<RaceResult>) = resultView.printResult(raceResults)

    private fun List<Car>.toRaceResult(): List<RaceResult> {
        return this.map {
            RaceResult(carId = it.getId(), position = it.currentPosition)
        }
    }

    data class RaceStartRequest(
        val carCount: Int,
        val totalRaceSet: Int,
    )
}
