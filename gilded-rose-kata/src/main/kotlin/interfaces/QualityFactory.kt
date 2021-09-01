package interfaces

import enums.*

const val MINIMUM_THRESHOLD = 0
const val MAXIMUM_THRESHOLD = 50

interface QualityFactory {

    fun makeQuality(quality: Int, modifier: Modifier): Int

}