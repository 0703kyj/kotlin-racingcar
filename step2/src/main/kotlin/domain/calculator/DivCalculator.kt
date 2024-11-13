package domain.calculator

import domain.calculator.enums.Operator

class DivCalculator : Calculator {
    override val operator: Operator = Operator.DIV

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        return firstNumber / secondNumber
    }
}
