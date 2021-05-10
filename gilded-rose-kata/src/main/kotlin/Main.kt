import models.*

fun main() {
    val items = mutableListOf(
            Default("+5 Dexterity Vest", 10, 20),
            Aged("Brie", 2, 0),
            Default("Elixir of the Mongoose", 5, 7),
            Sulfras("Hand of Ragnaros", 0, 80),
            Backstage("TAFKAL80ETC concert", 15, 20),
            Conjured("Mana Cake", 15, 20)
    )

    val gildedRose = GildedRose(items)
    gildedRose.runFor(20)
}

fun GildedRose.runFor(days: Int) {
    for (day in 1..days) {
        println("---- Day #$day ----")
        updateQuality()
        print()
        println()
    }
}

private fun GildedRose.print() = items.forEach { item -> println(item) }