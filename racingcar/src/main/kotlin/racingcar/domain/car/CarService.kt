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

    fun clear() = CarRepository.clear()

    fun findByPosition(maxPosition: Int): List<Car> {
        return CarRepository.findByPosition(maxPosition)
    }
}
