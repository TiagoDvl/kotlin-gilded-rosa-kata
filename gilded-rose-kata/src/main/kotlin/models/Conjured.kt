package models

import enums.*

class Conjured(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun getModifierFactorForDay(day: Int): Modifier {
        return Modifier.DOUBLE_DECAY
    }

    override fun getTag(): String = "Conjured $name"

}