package racingcar.domain.car

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("CarRepository 는")
class CarRepositoryTest {
    @BeforeEach
    fun beforeEach() {
        CarRepository.clear()
    }

    @Test
    fun `Car를 저장할 수 있다`() {
        CarRepository.save(Car())

        val cars = CarRepository.findAll()

        cars.size shouldBe 1
        cars[0].getId() shouldBe 0
    }

    @Test
    fun `Car를 여러 대 저장할 수 있다`() {
        val carCount = 3
        repeat(carCount) {
            CarRepository.save(Car())
        }

        val cars = CarRepository.findAll()

        cars.size shouldBe carCount
        cars.forEachIndexed { index, car ->
            car.getId() shouldBe index
        }
    }
}
