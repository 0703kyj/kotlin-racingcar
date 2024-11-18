package racingcar.view

object InputParser {
    private const val DELIMITER = ","

    fun String.splitByDelimiter(delimiter: String = DELIMITER): List<String> {
        return this.split(delimiter)
            .map { it.trim() }
    }
}
