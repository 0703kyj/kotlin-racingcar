package racingcar.domain.car

class CarService {
    fun registerAll(carNames: List<String>) {
        carNames.forEach { name ->
            runCatching {
                CarRepository.save(Car(name = name))
            }.onFailure {
                println("[CarService] 자동차 등록에 실패했습니다. | name, ${it.message}")
            }
        }
    }

    fun findAll(): List<Car> = CarRepository.findAll()

    fun findAllByMaxPosition(): List<Car> {
        val cars = CarRepository.findAll()
        val maxPosition = findFirstCar(cars).currentPosition

        return cars.filter { it.currentPosition == maxPosition }
    }

    fun clear() = CarRepository.clear()

    fun findByPosition(maxPosition: Int): List<Car> {
        return CarRepository.findByPosition(maxPosition)
    }

    private fun findFirstCar(cars: List<Car>): Car = cars.maxBy { it.currentPosition }
}
