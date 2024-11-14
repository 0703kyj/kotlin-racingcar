package domain.calculator.enums

enum class CalculateType(
    val type: String,
) {
    PLUS(type = "+"),
    MINUS(type = "-"),
    MULTIPLY(type = "*"),
    DIV(type = "/"),
    ;

    companion object {
        fun get(calculateType: String): CalculateType =
            entries.find { it.type == calculateType }
                ?: throw IllegalArgumentException("[CalculateType] 지원하지 않는 연산자입니다. | calculateType: '$calculateType'")
    }
}
