package domain.calculator

import domain.calculator.enums.Operator

interface Calculator {
    val operator: Operator

    fun support(operator: Operator): Boolean = this.operator == operator

    fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double
}
