package domain

import domain.calculator.Calculator
import domain.calculator.enums.CalculateType

class CalculatorAdapter(
    private val calculators: List<Calculator>,
) {
    fun get(calculateType: CalculateType): Calculator {
        return calculateType.run {
            calculators.find { it.support(this) }
        } ?: throw IllegalArgumentException("[CalculateAdapter] 지원하지 않는 연산자입니다 | operator: '$calculateType'")
    }
}
