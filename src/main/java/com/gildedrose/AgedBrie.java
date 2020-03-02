package com.gildedrose;

public class AgedBrie extends Item {
	public AgedBrie(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
	}

	@Override
	public void updateQualityAndSellIn() {
		if (quality < 50) {
			quality += 1;
		}
		updateSellIn();
		if (sellIn < 0 && quality < 50) {
			quality += 1;
		}
	}
}