package domain

import domain.calculator.Calculator
import domain.calculator.enums.Operator

class CalculatorAdapter(
    private val calculators: List<Calculator>,
) {
    fun get(operator: Operator): Calculator {
        return operator.run {
            calculators.find { it.support(this) }
        } ?: throw IllegalArgumentException("[CalculateAdapter] 지원하지 않는 연산자입니다 | operator: '$operator'")
    }
}
