package service

data class Numbers(
    private var values: List<Double>,
) {
    val size
        get() = values.size

    val firstNumber
        get() = values.getOrElse(0) {
            throw IllegalStateException("[Numbers] 첫 번째 숫자가 존재하지 않습니다. | size: $size")
        }

    val secondNumber
        get() = values.getOrElse(1) {
            throw IllegalStateException("[Numbers] 두 번째 숫자가 존재하지 않습니다. | size: $size")
        }

    fun getResult(): Double {
        check(size == 1) {
            "[Numbers] getResult 는 size 가 1일 때 사용할 수 있습니다. | size: $size"
        }
        return values[0]
    }

    fun canCalculate() = size % 2 == 0

    fun updateAfterCalculate(result: Double) {
        values = listOf(result) + values.drop(2)
    }
}
