package domain.calculator.enums

enum class CalculateType(
    val type: String,
    val calculate: (Double, Double) -> Double,
) {
    PLUS(type = "+", calculate = { firstNumber, secondNumber -> firstNumber + secondNumber }),
    MINUS(type = "-", calculate = { firstNumber, secondNumber -> firstNumber - secondNumber }),
    MULTIPLY(type = "*", calculate = { firstNumber, secondNumber -> firstNumber * secondNumber }),
    DIV(
        type = "/",
        calculate = { firstNumber, secondNumber ->
            require(secondNumber != 0.0) {
                "[DivCalculator] 0으로 나눌 수 없습니다. | firstNumber: $firstNumber, secondNumber: $secondNumber"
            }
            firstNumber / secondNumber
        },
    ),
    ;

    companion object {
        fun get(calculateType: String): CalculateType =
            entries.find { it.type == calculateType }
                ?: throw IllegalArgumentException("[CalculateType] 지원하지 않는 연산자입니다. | calculateType: '$calculateType'")
    }
}
