package domain.calculator

import domain.calculator.enums.Operator

class PlusCalculator : Calculator {
    override val operator: Operator = Operator.PLUS

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber + secondNumber
    }
}
