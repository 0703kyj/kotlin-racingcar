package racingcar.domain.car

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Accelerator 는")
class AcceleratorTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `tryForward를 호출했을 때, press가 4 이상인 경우 true를 반환한다`(value: Int) {
        val accelerator = Accelerator { value }

        accelerator.tryForward() shouldBe true
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `tryForward를 호출했을 때, press가 4 미만인 경우 false를 반환한다`(value: Int) {
        val accelerator = Accelerator { value }

        accelerator.tryForward() shouldBe false
    }
}
