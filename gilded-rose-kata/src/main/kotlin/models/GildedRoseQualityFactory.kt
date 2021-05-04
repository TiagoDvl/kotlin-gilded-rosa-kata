package models

import enums.*
import interfaces.*

class GildedRoseQualityFactory(override var quality: Int) : QualityFactory {

    companion object {
        const val MINIMUM_THRESHOLD = 0
        const val MAXIMUM_THRESHOLD = 50
    }

    override fun changeQualityValue(modifier: Modifier): Int {
        if (modifier == Modifier.STABLE) {
            return quality
        }

        quality += modifier.factor

        when {
            quality < MINIMUM_THRESHOLD -> quality = MINIMUM_THRESHOLD
            quality > MAXIMUM_THRESHOLD -> quality = MAXIMUM_THRESHOLD
        }

        return quality
    }

}
