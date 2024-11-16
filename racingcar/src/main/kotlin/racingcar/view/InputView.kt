package racingcar.view

object InputView {
    fun inputCarCount(): Int = input("자동차 대수는 몇 대인가요?").toIntOrThrow()
        .also { it.validateCarCount() }

    fun inputTotalRaceSet(): Int = input("시도할 횟수는 몇 회인가요?").toIntOrThrow()
        .also { it.validateTotalRaceSet() }

    private fun input(message: String): String {
        println(message)
        return readln()
    }

    private fun Int.validateCarCount() {
        require(this >= 1) {
            "[InputView] 참가하는 자동차의 대수는 1 이상이여야 합니다. | 자동차 대수: $this"
        }
    }

    private fun Int.validateTotalRaceSet() {
        require(this >= 1) {
            "[InputView] 시도 횟수는 1 이상이여야 합니다. | 시도 횟수: $this"
        }
    }

    private fun String.toIntOrThrow(): Int = runCatching {
        this.toInt()
    }.getOrElse { throw IllegalArgumentException("[InputView] 값을 Int로 변환하는데 실패했습니다. | '$this'") }
}
