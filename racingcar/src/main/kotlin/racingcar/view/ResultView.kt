package racingcar.view

class ResultView {
    fun printRaceResultTitle() = println(RACE_RESULT_TITLE)

    fun showResult(raceResults: List<RaceResult>) {
        raceResults.sortedBy { it.carId }
            .forEach {
                showResultPerCar(it)
            }
        println()
    }

    private fun showResultPerCar(raceResult: RaceResult) {
        println(CAR_MOVED_MARKER.repeat(raceResult.position))
    }

    data class RaceResult(
        val carId: Long,
        val position: Int,
    )

    companion object {
        private const val RACE_RESULT_TITLE = "실행 결과"
        private const val CAR_MOVED_MARKER = "-"
    }
}
