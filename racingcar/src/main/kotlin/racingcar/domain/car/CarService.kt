package racingcar.domain.car

class CarService {
    fun registerAll(carCount: Int) {
        repeat(carCount) {
            CarRepository.save(Car())
        }
    }

    fun findAll(): List<Car> = CarRepository.findAll()

    fun clear() = CarRepository.clear()
}
