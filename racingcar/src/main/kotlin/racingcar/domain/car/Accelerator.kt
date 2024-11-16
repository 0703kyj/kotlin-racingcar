package racingcar.domain.car

import kotlin.random.Random

class Accelerator {
    fun tryForward(): Boolean {
        return Random.nextInt(MAX_ACCELERATOR_VALUE) >= CAN_FORWARD_THRESHOLD
    }

    companion object {
        private const val CAN_FORWARD_THRESHOLD = 4
        private const val MAX_ACCELERATOR_VALUE = 10
    }
}
