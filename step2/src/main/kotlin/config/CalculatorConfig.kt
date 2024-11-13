package config

import domain.CalculatorAdapter
import domain.calculator.Calculator
import domain.calculator.DivCalculator
import domain.calculator.MinusCalculator
import domain.calculator.MultiplyCalculator
import domain.calculator.PlusCalculator

class CalculatorConfig {
    fun calculatorAdapter(): CalculatorAdapter {
        return CalculatorAdapter(calculators())
    }

    private fun calculators(): List<Calculator> {
        return listOf(
            PlusCalculator(),
            MinusCalculator(),
            MultiplyCalculator(),
            DivCalculator(),
        )
    }
}
