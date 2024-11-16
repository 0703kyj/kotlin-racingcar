package racingcar.service

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.RaceConfig
import racingcar.domain.car.CarRepository
import racingcar.domain.car.CarService

class RaceTest {
    private val race: Race = RaceConfig().race()
    private val carService: CarService = RaceConfig().carService()

    @BeforeEach
    fun beforeEach() {
        CarRepository.clear()
    }

    @Test
    fun `Car 가 등록되어 있는 경우 레이스를 진행한다`() {
        val carCount = 10
        carService.registerAll(carCount)

        race()

        val cars = CarRepository.findAll()
        cars.any { it.currentPosition != 0 } shouldBe true
    }
}
