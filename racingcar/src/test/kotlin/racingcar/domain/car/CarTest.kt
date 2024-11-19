package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Car 는")
class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2", "1,0", "3,2"])
    fun `처음 생성된 이후에 id를 수정할 수 없다`(oldId: Int, newId: Int) {
        val car = Car(name = "name").init(oldId)

        car.init(newId)

        car.getId() shouldBe oldId
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `tryForward에 성공한 경우 position이 1 올라간다`(value: Int) {
        val car = Car(name = "name", accelerator = { value })

        car.tryForward()

        car.currentPosition shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `tryForward에 실패한 경우 position이 올라가지 않는다`(value: Int) {
        val car = Car(name = "name", accelerator = { value })

        car.tryForward()

        car.currentPosition shouldBe 0
    }

    @Test
    fun `자동차의 이름은 5자를 초과할 수 없다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Car(name = "123456")
        }

        exception.message shouldContain "자동차의 이름은 1자 이상 5자 이하이어야 합니다"
    }
}
