import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters
import org.jeasy.random.randomizers.range.DoubleRangeRandomizer
import org.jeasy.random.randomizers.range.LongRangeRandomizer

object Fixture {
    val EASY_RANDOM = EasyRandomParameters()
        .collectionSizeRange(2, 3)
        .randomize(Long::class.java, LongRangeRandomizer(1, 10000))
        .randomize(Double::class.java, DoubleRangeRandomizer(1.0, 10000.0))
        .run { EasyRandom(this) }

    inline fun <reified T : Any> easyRandom(): T = EASY_RANDOM.nextObject(T::class.java)
}
