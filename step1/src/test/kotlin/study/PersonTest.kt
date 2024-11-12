package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 20, nickname = "홍")

        with(actual) {
            name shouldBe "홍길동"
            age shouldBe 20
            nickname shouldBe "홍"
        }
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 20, nickname = null)

        actual.nickname shouldBe null
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)

        actual.nickname shouldBe "홍길동"
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "홍길동", age = 20)
        val person2 = Person(name = "홍길동", age = 20)

        person1 shouldBe person2
    }
}
