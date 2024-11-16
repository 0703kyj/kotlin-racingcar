package racingcar

import racingcar.controller.RaceController
import racingcar.domain.car.CarService
import racingcar.service.Race

class RaceConfig {
    fun raceController(): RaceController {
        return RaceController(
            carService = carService(),
            race = race(),
        )
    }

    fun carService() = CarService()

    fun race() = Race(carService())
}
