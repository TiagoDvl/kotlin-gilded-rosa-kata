package models

import enums.*

class Aged(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun getModifierFactorForDay(day: Int): Modifier {
        return Modifier.ENHANCE
    }

    override fun getTag(): String = "Aged $name"

}