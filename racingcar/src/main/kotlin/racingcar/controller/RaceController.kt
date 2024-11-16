package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.car.CarRepository
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
    fun inputForRace() = inputView.inputForRace()

    fun register(carCount: Int) = carService.registerAll(carCount)

    fun startRace(totalRaceSet: Int) {
        resultView.printRaceResultTitle()

        repeat(totalRaceSet) {
            race()
            val cars = carService.findAll()
            resultView.printResult(cars.toRaceResult())
        }
    }

    fun endRace() {
        CarRepository.clear()
    }

    private fun List<Car>.toRaceResult(): List<RaceResult> {
        return this.map {
            RaceResult(carId = it.getId(), position = it.currentPosition)
        }
    }
}
