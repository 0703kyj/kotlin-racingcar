package racingcar.view

import racingcar.view.InputParser.splitByDelimiter

object InputView {
    fun inputCarCount(): Int = input("자동차 대수는 몇 대인가요?")
        .toIntOrThrow()
        .also { it.validateCarCount() }

    fun inputCarNames(): List<String> = input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        .splitByDelimiter()
        .filter { it.isNotBlank() }
        .also { it.validateCars() }

    fun inputTotalRaceSet(): Int = input("시도할 횟수는 몇 회인가요?")
        .toIntOrThrow()
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

    private fun List<String>.validateCars() {
        require(this.isNotEmpty()) {
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
