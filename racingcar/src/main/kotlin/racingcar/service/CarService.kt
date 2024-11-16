package racingcar.service

import racingcar.domain.Car
import racingcar.domain.CarRepository

class CarService(
    private val carRepository: CarRepository,
) {
    fun registerAll(carCount: Int) {
        repeat(carCount) {
            carRepository.save(Car())
        }
    }
}
