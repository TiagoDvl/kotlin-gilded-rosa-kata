package interfaces

import enums.*

interface QualityFactory {

    var quality: Int

    fun changeQualityValue(modifier: Modifier): Int

}