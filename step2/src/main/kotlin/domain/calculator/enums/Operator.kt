package domain.calculator.enums

enum class Operator(
    val operator: String,
) {
    PLUS(operator = "+"),
    MINUS(operator = "-"),
    MULTIPLY(operator = "*"),
    DIV(operator = "/"),
    ;

    companion object {
        fun get(operator: String): Operator =
            entries.find { it.operator == operator }
                ?: throw IllegalArgumentException("[Operator] 지원하지 않는 연산자입니다. | operator: '$operator'")
    }
}
