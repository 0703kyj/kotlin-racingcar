package domain.calculator

import domain.calculator.enums.Operator

/**
 * 구현 이후 CalculatorConfig 설정 필요
 */
interface Calculator {
    val operator: Operator

    fun support(operator: Operator): Boolean = this.operator == operator

    fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double
}
