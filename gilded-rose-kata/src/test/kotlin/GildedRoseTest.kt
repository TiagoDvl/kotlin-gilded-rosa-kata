import models.*
import kotlin.random.*
import kotlin.test.*

class GildedRoseTest {

    private val default = Default("+5 Dexterity Vest", 10, 20)
    private val aged = Aged("Brie", 2, 0)
    private val sulfras = Sulfras("Hand of Ragnaros", 0, 80)
    private val backstage = Backstage("TAFKAL80ETC concert", 15, 20)
    private val conjured = Conjured("Mana Cake", 15, 20)
    private val items = mutableListOf(default, aged, sulfras, backstage, conjured)

    private fun runGildedRoseForDays(items: List<Item>, days: Int = 20): GildedRose {
        val gildedRose = GildedRose(items)
        gildedRose.runFor(days)
        return gildedRose
    }

    @Test
    fun `Sulfras should not decay`() {
        val expectedQuality = 80
        val singleSulfrasItemList = listOf(Sulfras("Hand of Ragnaros", 0, expectedQuality))
        val sulfras = runGildedRoseForDays(singleSulfrasItemList, 10).items.filterIsInstance<Sulfras>().first()
        assert(sulfras.quality == expectedQuality)
    }

    @Test
    fun `Default items should have a constant decay`() {
        val days = 7
        val quality = days
        val listOfDefaultItem = listOf(Default("Elixir of the Mongoose", 5, quality))
        val gildedRoseItem = runGildedRoseForDays(listOfDefaultItem, days).items.first()
        assert(gildedRoseItem.quality == (days - quality))

    }

    @Test
    fun `Aged items should enhance quality on aging`() {
        val expectedQuality = 10
        val gildedRoseItem = runGildedRoseForDays(listOf(aged), expectedQuality).items.first()
        assert(gildedRoseItem.quality == expectedQuality)
    }

    @Test
    fun `Backstage items should behave differently depending of the sellIn date`() {
        val initialQuality = 20
        val backstageItem = Backstage("TAFKAL80ETC concert", 15, initialQuality)

        var gildedRoseItem = runGildedRoseForDays(listOf(backstageItem), 5)
        assert(gildedRoseItem.items.first().quality == 25 && gildedRoseItem.items.first().sellIn == 10)

        gildedRoseItem = runGildedRoseForDays(gildedRoseItem.items, 5)
        assert(gildedRoseItem.items.first().quality == 35 && gildedRoseItem.items.first().sellIn == 5)

        gildedRoseItem = runGildedRoseForDays(gildedRoseItem.items, 5)
        assert(gildedRoseItem.items.first().quality == 50 && gildedRoseItem.items.first().sellIn == 0)
    }

    @Test
    fun `Conjured items should decay twice as fast`() {
        val expectedQuality = 10
        val gildedRoseItem = runGildedRoseForDays(listOf(conjured), expectedQuality).items.first()
        assert(gildedRoseItem.quality == 0)
    }

    @Test
    fun `Items should never have negative quality`() {
        val gildedRose = runGildedRoseForDays(items, 100)
        val randItem = gildedRose.items[Random.nextInt(0,  gildedRose.items.size - 1)]
        assert(randItem.quality >= 0)
    }
}