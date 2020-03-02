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
	public void ordinaryItemSellInLess0() {
		Item[] items = new Item[]{new Item("foo", -1, 5)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
		assertThat(app.items[0].quality, is(3));
		assertThat(app.items[0].sellIn, is(-2));
	}

	@Test
	public void agedBrieQualityLessThan50() {
		Item[] items = new Item[]{new AgedBrie(2, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(1, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}

	@Test
	public void agedBrieSellInLessThan0() {
		Item[] items = new Item[]{new AgedBrie(-1, 1)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].quality);
		assertEquals(-2, app.items[0].sellIn);
	}

	@Test
	public void Sulfuras() {
		Item[] items = new Item[]{new Sulfuras(-1, 80)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Sulfuras", app.items[0].name);
		assertEquals(80, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInBy11() {
		Item[] items = new Item[]{new BackstagePass(11, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("BackstagePasses", app.items[0].name);
		assertEquals(31, app.items[0].quality);
		assertEquals(10, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInBetween6and11() {
		Item[] items = new Item[]{new BackstagePass(10, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("BackstagePasses", app.items[0].name);
		assertEquals(32, app.items[0].quality);
		assertEquals(9, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInLess6() {
		Item[] items = new Item[]{new BackstagePass(5, 33)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("BackstagePasses", app.items[0].name);
		assertEquals(36, app.items[0].quality);
		assertEquals(4, app.items[0].sellIn);
	}

	@Test
	public void backstagePassesQualityLess50SellInLess0() {
		Item[] items = new Item[]{new BackstagePass(-1, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("BackstagePasses", app.items[0].name);
		assertEquals(0, app.items[0].quality);
		assertEquals(-2, app.items[0].sellIn);
	}

	@Test
	public void conjuredItem() {
		Item[] items = new Item[]{new Conjured(2, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Conjured", app.items[0].name);
		assertEquals(29, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);
	}

	@Test
	public void conjuredItemSellInLess0() {
		Item[] items = new Item[]{new Conjured(-1, 30)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Conjured", app.items[0].name);
		assertEquals(28, app.items[0].quality);
		assertEquals(-2, app.items[0].sellIn);
	}
}
