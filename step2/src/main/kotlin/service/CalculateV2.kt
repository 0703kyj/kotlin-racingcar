package service

import domain.calculator.enums.CalculateType

class CalculateV2 {
    operator fun invoke(
        numbers: Numbers,
        calculateTypes: List<CalculateType>,
    ): Double {
        check(numbers.canCalculate()) {
            "[Calculate] 연산에 적어도 숫자 2개가 필요합니다. | numbers: ${numbers.size}"
        }

        calculateTypes.forEach { calculateType ->
            numbers.calculate(calculateType)
        }
        return numbers.getResult()
    }
}
