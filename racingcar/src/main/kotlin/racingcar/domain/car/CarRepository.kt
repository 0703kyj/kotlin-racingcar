package racingcar.domain.car

object CarRepository {
    private var lastRegisteredCarId: Int = 0
    private var cars: MutableMap<Int, Car> = mutableMapOf()

    fun save(car: Car) {
        cars[lastRegisteredCarId] = car.init(lastRegisteredCarId)
        lastRegisteredCarId += 1
    }

    fun findAll(): List<Car> {
        return cars.values
            .toList()
            .sortedBy { it.getId() }
    }

    fun clear() {
        lastRegisteredCarId = 0
        cars = mutableMapOf()
    }
}
