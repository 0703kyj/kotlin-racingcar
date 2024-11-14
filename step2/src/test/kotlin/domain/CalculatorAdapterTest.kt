package domain

import config.CalculatorConfig
import domain.calculator.enums.CalculateType
import io.kotest.assertions.throwables.shouldNotThrowAny
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class CalculatorAdapterTest {
    private val calculatorAdapter = CalculatorConfig().calculatorAdapter()

    /**
     * 테스트가 실패하는 경우
     * 1. Operator 에 해당 하는 Calculator 구현
     * 2. CalculatorConfig 에 구현한 Calculator 추가
     */
    @ParameterizedTest
    @EnumSource(CalculateType::class)
    fun `Operator에 해당하는 모든 Calcultor를 찾을 수 있다`(calculateType: CalculateType) {
        shouldNotThrowAny {
            calculatorAdapter.get(calculateType)
        }
    }
}
