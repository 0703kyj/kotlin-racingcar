package domain.calculator

import domain.calculator.enums.CalculateType

class MinusCalculator : Calculator {
    override val calculateType: CalculateType = CalculateType.MINUS

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber - secondNumber
    }
}
