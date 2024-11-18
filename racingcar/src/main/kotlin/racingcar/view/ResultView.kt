package racingcar.view

object ResultView {
    fun printRaceResultTitle() = println(RACE_RESULT_TITLE)

    fun printResult(raceResults: List<RaceResult>) {
        raceResults.sortedBy { it.carId }
            .forEach {
                printResultPerCar(it)
            }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun printResultPerCar(raceResult: RaceResult) {
        val currentPosition = CAR_MOVED_MARKER.repeat(raceResult.position)
        println("${raceResult.name} : $currentPosition")
    }

    data class RaceResult(
        val carId: Int,
        val name: String,
        val position: Int,
    )

    private const val RACE_RESULT_TITLE = "실행 결과"
    private const val CAR_MOVED_MARKER = "-"
}
