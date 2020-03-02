package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void ordinaryItem() {
		Item[] items = new Item[]{new Item("foo", 1, 5)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
		assertThat(app.items[0].quality, is(4));
		assertThat(app.items[0].sellIn, is(0));
	}

	@Test
	public void agedBrieQualityLessThan50() {
		Item[] items = new Item[]{new AgedBrie("Aged Brie", 2, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(1, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}

	@Test
	public void agedBrieSellInLessThan0() {
		Item[] items = new Item[]{new AgedBrie("Aged Brie", -1, 1)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].quality);
		assertEquals(-2, app.items[0].sellIn);
	}

	@Test
	public void Sulfuras() {
		Item[] items = new Item[]{new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
		assertEquals(80, app.items[0].quality);
		assertEquals(-1,app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInBy11() {
		Item[] items = new Item[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 11, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
		assertEquals(31, app.items[0].quality);
		assertEquals(10, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInBetween6and11() {
		Item[] items = new Item[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
		assertEquals(32, app.items[0].quality);
		assertEquals(9, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInLess6() {
		Item[] items = new Item[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 33)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
		assertEquals(36, app.items[0].quality);
		assertEquals(4, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInLess0() {
		Item[] items = new Item[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", -1, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
		assertEquals(0, app.items[0].quality);
		assertEquals(-2, app.items[0].sellIn);
	}

	@Test
	public void conjuredItem() {
		Item[] items = new Item[]{new Conjured("Conjured", 2, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Conjured", app.items[0].name);
		assertEquals(29, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);
	}
}
