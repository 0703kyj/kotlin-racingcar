package service

data class Numbers(
    private var values: List<Double>,
) {
    fun getFirstNumber() = values.getOrElse(0) {
        throw IllegalStateException()
    }

    fun getSecondNumber() = values.getOrElse(1) {
        throw IllegalStateException()
    }

    fun getResult(): Double {
        check(values.size == 1)
        return values[0]
    }

    fun canCalculate() = values.size >= 2

    fun updateAfterCalculate(result: Double) {
        values = listOf(result) + values.drop(2)
    }
}
