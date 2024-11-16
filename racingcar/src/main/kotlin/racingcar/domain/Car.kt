package racingcar.domain

class Car(
    private var id: Int = 0,
    private var position: Int = 0,
) {
    val currentPosition
        get() = position

    fun init(id: Int): Car {
        if (id == 0) {
            this.id = id
        }
        return this
    }
}
