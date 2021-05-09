import models.*

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) item.onDayTick()
    }

}