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
            check(numbers.canCalculate())

            val result = calculate(
                firstNumber = numbers.getFirstNumber(),
                secondNumber = numbers.getSecondNumber(),
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
