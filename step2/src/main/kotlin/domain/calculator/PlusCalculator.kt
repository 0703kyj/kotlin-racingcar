package domain.calculator

import domain.calculator.enums.CalculateType

class PlusCalculator : Calculator {
    override val calculateType: CalculateType = CalculateType.PLUS

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber + secondNumber
    }
}
