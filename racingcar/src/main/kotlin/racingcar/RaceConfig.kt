package racingcar

import racingcar.controller.RaceController
import racingcar.domain.CarRepository
import racingcar.service.CarService
import racingcar.service.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceConfig {
    fun raceController(): RaceController {
        return RaceController(
            inputView = inputView(),
            resultView = resultView(),
            carService = carService(),
            race = race(),
        )
    }

    private fun race() = Race(carService())

    private fun carService() = CarService(carRepository())

    private fun carRepository() = CarRepository()

    private fun inputView(): InputView = InputView()

    private fun resultView(): ResultView = ResultView()
}