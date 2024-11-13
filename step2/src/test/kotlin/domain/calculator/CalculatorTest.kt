package domain.calculator

import Fixture.easyRandom
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Calculator 를 구현한")
class CalculatorTest {
    lateinit var calculator: Calculator

    @Nested
    @DisplayName("PlusCalculator 는")
    inner class PlusCalculatorTest {
        init {
            calculator = PlusCalculator()
        }

        @Test
        fun `덧셈을 수행한다`() {
            val firstNumber = easyRandom<Double>()
            val secondNumber = easyRandom<Double>()

            val result = calculator.calculate(firstNumber, secondNumber)

            result shouldBe firstNumber + secondNumber
        }
    }

    @Nested
    @DisplayName("MinusCalculator 는")
    inner class MinusCalculatorTest {
        init {
            calculator = MinusCalculator()
        }

        @Test
        fun `덧셈을 수행한다`() {
            val firstNumber = easyRandom<Double>()
            val secondNumber = easyRandom<Double>()

            val result = calculator.calculate(firstNumber, secondNumber)

            result shouldBe firstNumber - secondNumber
        }
    }

    @Nested
    @DisplayName("MultiplyCalculator 는")
    inner class MultiplyCalculatorTest {
        init {
            calculator = MultiplyCalculator()
        }

        @Test
        fun `덧셈을 수행한다`() {
            val firstNumber = easyRandom<Double>()
            val secondNumber = easyRandom<Double>()

            val result = calculator.calculate(firstNumber, secondNumber)

            result shouldBe firstNumber * secondNumber
        }
    }

    @Nested
    @DisplayName("DivCalculator 는")
    inner class DivCalculatorTest {
        init {
            calculator = DivCalculator()
        }

        @Test
        fun `나눗셈을 수행한다`() {
            val firstNumber = easyRandom<Double>()
            val secondNumber = easyRandom<Double>()

            val result = calculator.calculate(firstNumber, secondNumber)

            result shouldBe firstNumber / secondNumber
        }
    }
}
