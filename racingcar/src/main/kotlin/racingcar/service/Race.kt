package racingcar.service

import racingcar.domain.car.Car
import racingcar.domain.car.CarService

class Race(
    private val carService: CarService,
) {
    operator fun invoke(): List<Car> {
        val cars = carService.findAll()

        cars.forEach { car ->
            car.tryForward()
        }
        return carService.findAll()
    }

    fun findWinners(): List<Car> {
        val cars = carService.findAll()
        val maxPosition = findFirstCar(cars).currentPosition

        return carService.findByPosition(maxPosition)
    }

    private fun findFirstCar(cars: List<Car>): Car = cars.maxBy { it.currentPosition }
}
