package racingcar.domain.car

fun interface Accelerator {
    fun press(): Int

    fun tryForward(): Boolean {
        return press() >= CAN_FORWARD_THRESHOLD
    }

    companion object {
        private const val CAN_FORWARD_THRESHOLD = 4
    }
}
