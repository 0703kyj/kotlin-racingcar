package racingcar.controller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.RaceConfig
import racingcar.domain.car.Car
import racingcar.domain.car.CarRepository

class RaceControllerTest {
    private val raceController: RaceController = RaceConfig().raceController()

    @BeforeEach
    fun beforeEach() {
        CarRepository.clear()
    }

    @Test
    fun `findWinners는 우승자의 이름만 반환한다`() {
        val cars = List(10) {
            Car(name = "name$it", position = it).also {
                CarRepository.save(it)
            }
        }

        val winners = raceController.findWinners()

        winners.size shouldBe 1
        winners.forEach {
            it shouldBe cars.maxBy { car -> car.currentPosition }.name
        }
    }
}
