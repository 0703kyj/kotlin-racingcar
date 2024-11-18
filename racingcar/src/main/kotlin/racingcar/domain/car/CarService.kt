package racingcar.domain.car

class CarService {
    fun registerAll(carNames: List<String>) {
        carNames.forEach { name ->
            require(name.isNotBlank()) {
                "[CarService] 자동차 이름이 존재하지 않습니다. | name: '$name'"
            }
            CarRepository.save(Car(name = name))
        }
    }

    fun findAll(): List<Car> = CarRepository.findAll()

    fun clear() = CarRepository.clear()

    fun findByPosition(maxPosition: Int): List<Car> {
        return CarRepository.findByPosition(maxPosition)
    }
}
