package racingcar.domain

class CarRepository(
    private var cars: MutableMap<Int, Car> = mutableMapOf(),
) {
    private var lastRegisteredCarId: Int = 0

    fun save(car: Car) {
        cars[lastRegisteredCarId] = car.init(lastRegisteredCarId)
        lastRegisteredCarId += 1
    }
}
