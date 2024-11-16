package racingcar.view

import racingcar.domain.RaceSet

class ResultView {
    fun showResult(totalRaceSet: Int, raceResults: List<RaceResultDto>) {
        println(RACE_RESULT_TITLE)
        for (i in 1..totalRaceSet) {
            RaceSet(i).showResult(raceResults)
        }
    }

    private fun RaceSet.showResult(raceResults: List<RaceResultDto>) {
        raceResults.sortedBy { it.carId }
            .forEach {
                showResultPerCar(it)
            }
        println()
    }

    private fun RaceSet.showResultPerCar(raceResult: RaceResultDto) {
        val position = raceResult.getPositionPerRaceSet(this)
        println(CAR_MOVED_MARKER.repeat(position))
    }

    data class RaceResultDto(
        val carId: Long,
        val position: Map<RaceSet, Int>,
    ) {
        fun getPositionPerRaceSet(raceSet: RaceSet): Int =
            position.getOrElse(raceSet) {
                error("[RaceResultDto] carId($carId)에 해당하는 Car의 ${raceSet.value}세트 결과가 존재하지 않습니다.")
            }
    }

    companion object {
        private const val RACE_RESULT_TITLE = "실행 결과"
        private const val CAR_MOVED_MARKER = "-"
    }
}
