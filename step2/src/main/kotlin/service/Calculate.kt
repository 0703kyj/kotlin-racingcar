package service

import config.CalculatorConfig
import domain.CalculatorAdapter
import domain.calculator.enums.CalculateType

class Calculate(
    private val calculatorAdapter: CalculatorAdapter = CalculatorConfig().calculatorAdapter(),
) {
    operator fun invoke(
        numbers: Numbers,
        calculateTypes: List<CalculateType>,
    ): Double {
        check(numbers.canCalculate()) {
            "[Calculate] 연산에 숫자가 짝수 개가 필요합니다. | numbers: ${numbers.size}"
        }
        calculateTypes.forEach { calculateType ->
            val result = calculate(
                firstNumber = numbers.firstNumber,
                secondNumber = numbers.secondNumber,
                calculateType = calculateType,
            )
            numbers.updateAfterCalculate(result)
        }
        return numbers.getResult()
    }

    private fun calculate(
        firstNumber: Double,
        secondNumber: Double,
        calculateType: CalculateType,
    ): Double {
        val calculator = calculatorAdapter.get(calculateType)

        val result = calculator.calculate(firstNumber, secondNumber)
        return result
    }
}
