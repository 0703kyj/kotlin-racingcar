package domain.calculator

import domain.calculator.enums.CalculateType

/**
 * 구현 이후 CalculatorConfig 설정 필요
 */
interface Calculator {
    val calculateType: CalculateType

    fun support(calculateType: CalculateType): Boolean = this.calculateType == calculateType

    fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double
}
