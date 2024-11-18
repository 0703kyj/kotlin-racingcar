package racingcar.service

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.RaceConfig
import racingcar.domain.car.Car
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
        val carNames = List(10) { "name$it" }
        carService.registerAll(carNames)

        race()

        val cars = CarRepository.findAll()
        cars.any { it.currentPosition != 0 } shouldBe true
    }

    @Test
    fun `우승자는 position이 가장 큰 Car로 선정된다`() {
        List(10) { Car(name = "name$it", position = it) }.forEach {
            CarRepository.save(it)
        }

        val findWinners = race.findWinners()
        val winner = findWinners.first()

        findWinners.size shouldBe 1
        winner.currentPosition shouldBe 9
        winner.name shouldBe "name9"
    }

    @Test
    fun `공동 우승자가 있는 경우 모두 선정된다`() {
        List(10) { Car(name = "name$it", position = it % 2) }.forEach {
            CarRepository.save(it)
        }

        val findWinners = race.findWinners()

        findWinners.size shouldBe 5
        findWinners.forEach {
            it.currentPosition shouldBe 1
        }
    }
}
