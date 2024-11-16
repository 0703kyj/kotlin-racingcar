package racingcar.domain.car

import kotlin.random.Random

class RandomAccelerator : Accelerator {
    override fun press(): Int = Random.nextInt(MAX_ACCELERATOR_VALUE + 1)

    companion object {
        private const val MAX_ACCELERATOR_VALUE = 9
    }
}
