import domain.calculator.enums.CalculateType
import service.Calculate
import service.CalculateV2
import service.Numbers

private val calculate: Calculate = Calculate()
private val calculateV2: CalculateV2 = CalculateV2()

fun main() {
    val calculateRequest = CalculateRequest.from(readlnOrNull())

    println(calculateV2(numbers = calculateRequest.numbers, calculateTypes = calculateRequest.calculateTypes))
}

data class CalculateRequest(
    val numbers: Numbers,
    val calculateTypes: List<CalculateType>,
) {
    companion object {
        private const val SPACE = " "

        /**
         * 입력 값은 숫자와 사칙연산자가 반복되는 형태
         *
         * 홀수 자리: 숫자
         * 짝수 자리: 연산자
         *
         * ex) 3 + 4 - 5 * 2 / 1
         */
        fun from(input: String?): CalculateRequest {
            require(!input.isNullOrBlank()) {
                "[CalculateRequest] 입력 값은 null 이거나 빈값일 수 없습니다. | 입력 값: '$input'"
            }
            val values = input.split(SPACE)
                .filter { it.isNotBlank() }

            return CalculateRequest(
                numbers = Numbers(values.filterNumbers()),
                calculateTypes = values.filterCalculateTypes(),
            )
        }

        private fun List<String>.filterNumbers() =
            this.asSequence()
                .filterIndexed { index, _ -> index % 2 == 0 }
                .map { it.toNumber() }
                .toList()

        private fun List<String>.filterCalculateTypes() =
            this.asSequence()
                .filterIndexed { index, _ -> index % 2 == 1 }
                .map { CalculateType.get(it) }
                .toList()

        private fun String.toNumber(): Double {
            return runCatching {
                this.toDouble()
            }.getOrElse { throw IllegalArgumentException("[Request] 숫자가 아니면 변환할 수 없습니다. | 입력값: '$this'") }
        }
    }
}
