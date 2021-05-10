package models

import enums.*

abstract class Item(val name: String, var sellIn: Int, var quality: Int) {

    override fun toString() = "${getTag()} | sell in $sellIn | quality of ${quality}"

    abstract fun getModifierFactorForDay(day: Int): Modifier

    abstract fun getTag(): String

    fun onDayTick() {
        quality = GildedRoseQualityFactory.makeQuality(quality, getModifierFactorForDay(sellIn))
        sellIn --
    }

}