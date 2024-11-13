import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class CalculateRequestTest {
    @Test
    fun `입력 값이 빈 값인 경우 CalculateRequest를 생성할 수 없다`() {
        val input = ""

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "입력 값은 null 이거나 빈값일 수 없습니다"
    }

    @Test
    fun `입력 값이 null 인 경우 CalculateRequest를 생성할 수 없다`() {
        val input = null

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "입력 값은 null 이거나 빈값일 수 없습니다"
    }

    @Test
    fun `연산 식이 숫자로 시작하지 않는 경우 예외가 발생한다`() {
        val input = "* 1 + 2"

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "숫자가 아니면 변환할 수 없습니다"
    }

    @Test
    fun `연산 식의 두번째 문자가 숫자이면 경우 예외가 발생한다`() {
        val input = "1 2 3 + 2"

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "지원하지 않는 연산자입니다"
    }

    @Test
    fun `연산 식의 연산자가 사칙연산 기호가 아닌 경우 예외가 발생한다`() {
        val input = "1 ^ 2"

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "지원하지 않는 연산자입니다"
    }

    @Test
    fun `공백이 아닌 구분자가 들어오는 경우 예외가 발생한다`() {
        val input = "1,+,2"

        val exception = shouldThrowExactly<IllegalArgumentException> {
            CalculateRequest.from(input)
        }

        exception.message shouldContain "숫자가 아니면 변환할 수 없습니다"
    }
}
