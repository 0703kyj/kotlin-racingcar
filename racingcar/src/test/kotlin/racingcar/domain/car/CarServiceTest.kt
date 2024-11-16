package racingcar.domain.car

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.RaceConfig

@DisplayName("CarService 는")
class CarServiceTest {
    private val carService: CarService = RaceConfig().carService()

    @BeforeEach
    fun beforeEach() {
        CarRepository.clear()
    }

    @Test
    fun `carCount 만큼 출전 자동차를 등록할 수 있다`() {
        val carCount = 10

        carService.registerAll(carCount)

        val cars = CarRepository.findAll()

        cars.size shouldBe carCount
        cars.forEachIndexed { index, car ->
            car.getId() shouldBe index
        }
    }

    @ParameterizedTest
    @ValueSource(ints = intArrayOf(0, -1, -2, -3, -4))
    fun `carCount가 0이하인 경우 등록 되지 않는다`(carCount: Int) {
        carService.registerAll(carCount)

        val cars = CarRepository.findAll()

        cars.size shouldBe 0
    }
}
