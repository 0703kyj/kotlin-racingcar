package domain.calculator

import domain.calculator.enums.Operator

class MultiplyCalculator : Calculator {
    override val operator: Operator = Operator.MULTIPLY

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber * secondNumber
    }
}
