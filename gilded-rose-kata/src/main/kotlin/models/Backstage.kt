package models

import enums.*

class Backstage(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun getModifierFactorForDay(day: Int): Modifier {
        return getBackstageModifier(day)
    }

    private fun getBackstageModifier(day: Int): Modifier {
        return when {
            day <= 10 -> Modifier.DOUBLE
            day <= 5 -> Modifier.TRIPLE
            day <= 0 -> Modifier.STABLE
            else -> Modifier.ENHANCE
        }
    }

    override fun getTag(): String = "Backstage passes to $name"

}