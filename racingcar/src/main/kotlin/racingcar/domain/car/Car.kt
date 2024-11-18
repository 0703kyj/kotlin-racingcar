package racingcar.domain.car

class Car(
    private var id: Int = 0,
    val name: String,
    private var position: Int = 0,
    private val accelerator: Accelerator = RandomAccelerator(),
) : Comparable<Car> {
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

    override fun compareTo(other: Car): Int {
        return compareValuesBy(this, other) { it.position }
    }
}
