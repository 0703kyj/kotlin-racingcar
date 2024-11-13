package service

import config.CalculatorConfig
import domain.CalculatorAdapter
import domain.calculator.enums.Operator

class Calculate(
    private val calculatorAdapter: CalculatorAdapter = CalculatorConfig().calculatorAdapter(),
) {
    operator fun invoke(
        numbers: Numbers,
        operators: List<Operator>,
    ): Double {
        operators.forEach { operator ->
            check(numbers.canCalculate()) {
                "[Calculate] 연산에 적어도 숫자 2개가 필요합니다. | numbers: ${numbers.size}"
            }

            val result = calculate(
                firstNumber = numbers.firstNumber,
                secondNumber = numbers.secondNumber,
                operator = operator,
            )
            numbers.updateAfterCalculate(result)
        }
        return numbers.getResult()
    }

    private fun calculate(
        firstNumber: Double,
        secondNumber: Double,
        operator: Operator,
    ): Double {
        val calculator = calculatorAdapter.get(operator)

        val result = calculator.calculate(firstNumber, secondNumber)
        return result
    }
}
