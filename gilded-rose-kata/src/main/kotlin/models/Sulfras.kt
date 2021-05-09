package models

import enums.*

class Sulfras(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun getModifierFactorForDay(day: Int): Modifier {
        return Modifier.STABLE
    }

    override fun getTag(): String = "Sulfras, $name"
}