package racingcar.domain.car

class Car(
    private var id: Int = 0,
    private var position: Int = 0,
    private val accelerator: Accelerator = RandomAccelerator(),
) {
    val currentPosition
        get() = position

    fun getId() = id

    fun init(id: Int): Car {
        if (this.id == 0) {
            this.id = id
        }
        return this
    }

    fun tryForward() {
        if (accelerator.tryForward()) {
            position++
        }
    }
}
