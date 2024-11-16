package racingcar.view

class InputView {
    fun inputForRace(): RaceStartRequest {
        val carCount = input("자동차 대수는 몇 대인가요?").toIntOrThrow()
        val totalRaceSet = input("시도할 횟수는 몇 회인가요?").toIntOrThrow()

        return RaceStartRequest(carCount = carCount, totalRaceSet = totalRaceSet)
    }

    private fun input(message: String): String {
        println(message)
        return readln()
    }

    data class RaceStartRequest(
        val carCount: Int,
        val totalRaceSet: Int,
    )

    private fun String.toIntOrThrow(): Int = runCatching {
        this.toInt()
    }.getOrElse { throw IllegalArgumentException("[InputView] 값을 Int로 변환하는데 실패했습니다. | '$this'") }
}
