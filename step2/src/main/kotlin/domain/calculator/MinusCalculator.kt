package domain.calculator

import domain.calculator.enums.Operator

class MinusCalculator : Calculator {
    override val operator: Operator = Operator.MINUS

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber - secondNumber
    }
}
