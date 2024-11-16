package racingcar.service

import racingcar.domain.car.CarService

class Race(
    private val carService: CarService,
) {
    operator fun invoke() {
        val cars = carService.findAll()

        cars.forEach { car ->
            car.tryForward()
        }
    }
}
