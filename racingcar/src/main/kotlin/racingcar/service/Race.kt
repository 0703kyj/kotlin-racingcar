package racingcar.service

class Race(
    private val carService: CarService,
) {
    data class Result(
        val carId: Long,
        val position: Int,
    )

    operator fun invoke(): List<Result> {
        return emptyList()
    }
}
