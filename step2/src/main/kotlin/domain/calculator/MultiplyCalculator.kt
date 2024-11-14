package domain.calculator

import domain.calculator.enums.CalculateType

class MultiplyCalculator : Calculator {
    override val calculateType: CalculateType = CalculateType.MULTIPLY

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber * secondNumber
    }
}
