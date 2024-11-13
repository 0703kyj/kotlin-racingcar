package service

import Fixture.easyRandom
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class CalculateTest {
    private val calculate: Calculate = Calculate()

    @Test
    fun `계산할 숫자의 갯수가 2보다 작으면 예외가 발생한다`() {
        val numbers = Numbers(listOf(easyRandom()))

        val exception = shouldThrowExactly<IllegalStateException> {
            calculate(numbers, listOf(easyRandom()))
        }

        exception.message shouldContain "연산에 적어도 숫자 2개가 필요합니다"
    }
}
