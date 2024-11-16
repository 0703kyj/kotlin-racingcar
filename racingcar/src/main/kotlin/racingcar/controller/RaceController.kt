package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.car.CarService
import racingcar.service.Race
import racingcar.view.ResultView.RaceResult

class RaceController(
    private val carService: CarService,
    private val race: Race,
) {
    fun register(carCount: Int) = carService.registerAll(carCount)

    fun startRace(): List<RaceResult> = race().toRaceResult()

    fun endRace() = carService.clear()

    private fun List<Car>.toRaceResult(): List<RaceResult> {
        return this.map {
            RaceResult(carId = it.getId(), position = it.currentPosition)
        }
    }
}
