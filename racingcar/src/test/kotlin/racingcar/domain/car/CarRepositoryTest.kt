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
        CarRepository.save(Car(name = "name"))

        val cars = CarRepository.findAll()

        cars.size shouldBe 1
        cars[0].getId() shouldBe 0
    }

    @Test
    fun `Car를 여러 대 저장할 수 있다`() {
        val carCount = 3
        repeat(carCount) {
            CarRepository.save(Car(name = "name"))
        }

        val cars = CarRepository.findAll()

        cars.size shouldBe carCount
        cars.forEachIndexed { index, car ->
            car.getId() shouldBe index
        }
    }

    @Test
    fun `currentPosition이 position인 모든 Car를 조회할 수 있다`() {
        val carCount = 3
        repeat(carCount) {
            CarRepository.save(Car(name = "name", position = 0))
            CarRepository.save(Car(name = "name", position = 1))
        }

        val positionZeroCars = CarRepository.findByPosition(0)
        val positionOneCars = CarRepository.findByPosition(1)

        positionZeroCars.size shouldBe carCount
        positionZeroCars.forEach {
            it.currentPosition shouldBe 0
        }

        positionOneCars.size shouldBe carCount
        positionOneCars.forEach {
            it.currentPosition shouldBe 1
        }
    }
}
