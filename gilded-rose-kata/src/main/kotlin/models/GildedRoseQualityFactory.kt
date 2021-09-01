package models

import enums.*
import interfaces.*

object GildedRoseQualityFactory : QualityFactory {

    override fun makeQuality(quality: Int, modifier: Modifier): Int {
        var tempQuality = quality
        if (modifier == Modifier.STABLE) {
            return tempQuality
        }

        tempQuality += modifier.factor

        when {
            quality < MINIMUM_THRESHOLD -> tempQuality = MINIMUM_THRESHOLD
            quality > MAXIMUM_THRESHOLD -> tempQuality = MAXIMUM_THRESHOLD
        }

        return tempQuality
    }

}
