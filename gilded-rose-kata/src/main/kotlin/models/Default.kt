package models

import enums.*

class Default(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun getModifierFactorForDay(day: Int): Modifier {
        return Modifier.DECAY
    }

    override fun getTag(): String = name

}
