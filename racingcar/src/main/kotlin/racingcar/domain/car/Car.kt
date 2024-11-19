package racingcar.domain.car

class Car(
    private var id: Int = 0,
    val name: String,
    private var position: Int = 0,
    private val accelerator: Accelerator = RandomAccelerator(),
) {
    init {
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            "[Car] 자동차의 이름은 1자 이상 5자 이하이어야 합니다. | name: $name, size: ${name.length}"
        }
    }

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

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
