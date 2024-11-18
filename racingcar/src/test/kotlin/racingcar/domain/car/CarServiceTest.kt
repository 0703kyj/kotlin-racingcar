package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.RaceConfig
import racingcar.view.InputParser.splitByDelimiter

@DisplayName("CarService 는")
class CarServiceTest {
    private val carService: CarService = RaceConfig().carService()

    @BeforeEach
    fun beforeEach() {
        CarRepository.clear()
    }

    @Test
    fun `carCount 만큼 출전 자동차를 등록할 수 있다`() {
        val carNames = listOf("car1", "car2", "car3")

        carService.registerAll(carNames)

        val cars = CarRepository.findAll()

        cars.size shouldBe carNames.size
        cars.forEachIndexed { index, car ->
            car.getId() shouldBe index
            car.name shouldBe carNames[index]
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ",,", "name,,"])
    fun `carCount가 0이하인 경우 등록 되지 않는다`(carNames: String) {
        shouldThrowExactly<IllegalArgumentException> {
            carService.registerAll(carNames.splitByDelimiter())
        }
    }
}
