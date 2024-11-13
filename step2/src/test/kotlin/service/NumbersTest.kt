package service

import Fixture.easyRandom
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `숫자가 없는데 첫 번째 숫자를 조회하려는 경우 예외가 발생한다`() {
        val numbers = Numbers(emptyList())

        val exception = shouldThrowExactly<IllegalStateException> {
            numbers.firstNumber
        }

        exception.message shouldContain "첫 번째 숫자가 존재하지 않습니다"
    }

    @Test
    fun `숫자가 하나만 존재하는데 두 번째 숫자를 조회하려는 경우 예외가 발생한다`() {
        val numbers = Numbers(listOf(easyRandom()))

        val exception = shouldThrowExactly<IllegalStateException> {
            numbers.secondNumber
        }

        exception.message shouldContain "두 번째 숫자가 존재하지 않습니다"
    }

    @Test
    fun `연산이 마무리 되기 전에 getResult를 호출하는 경우 예외가 발생한다`() {
        val numbers = Numbers(listOf(easyRandom(), easyRandom()))

        val exception = shouldThrowExactly<IllegalStateException> {
            numbers.getResult()
        }

        exception.message shouldContain "getResult 는 size 가 1일 때 사용할 수 있습니다"
    }
}
