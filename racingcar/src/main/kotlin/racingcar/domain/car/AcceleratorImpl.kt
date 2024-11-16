package racingcar.domain.car

import kotlin.random.Random

class AcceleratorImpl : Accelerator {
    override fun press(): Int = Random.nextInt(MAX_ACCELERATOR_VALUE)

    companion object {
        private const val MAX_ACCELERATOR_VALUE = 10
    }
}
