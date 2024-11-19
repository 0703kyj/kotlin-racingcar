package racingcar.domain.car

class CarService {
    fun registerAll(carNames: List<String>) {
        carNames.forEach { name ->
            CarRepository.save(Car(name = name))
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
