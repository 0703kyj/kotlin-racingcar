package domain.calculator

import domain.calculator.enums.Operator

class DivCalculator : Calculator {
    override val operator: Operator = Operator.DIV

    override fun calculate(
        firstNumber: Double,
        secondNumber: Double,
    ): Double {
        require(secondNumber.isNotZero()) {
            "[DivCalculator] 0으로 나눌 수 없습니다. | firstNumber: $firstNumber, secondNumber: $secondNumber"
        }

        return firstNumber / secondNumber
    }

    private fun Double.isNotZero() = this != 0.0
}
