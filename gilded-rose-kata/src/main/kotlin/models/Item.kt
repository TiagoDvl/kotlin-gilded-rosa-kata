package models

import enums.*
import interfaces.*

abstract class Item(val name: String, var sellIn: Int, private val quality: Int): ItemQualityModifier {

    private val qualityFactory: QualityFactory = GildedRoseQualityFactory(quality)

    override fun toString() = "${getTag()} | sell in $sellIn | quality of ${qualityFactory.quality}"

    abstract fun getModifierFactorForDay(day: Int): Modifier

    abstract fun getTag(): String

    override fun onDayTick() {
        qualityFactory.changeQualityValue(getModifierFactorForDay(sellIn))
        sellIn --
    }

    override fun onFinalDay() {
        println("Final day for: $name")
    }

}