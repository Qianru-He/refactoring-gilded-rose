package com.gildedrose;

public class Conjured extends Item {
	public Conjured(int sellIn, int quality) {
		super("Conjured", sellIn, quality);
	}

	@Override
	public void updateQualityAndSellIn() {
		int temp = quality - 1;
		quality = Math.max(temp, 0);

		updateSellIn();

		if (sellIn < 0) {
			temp = quality - 1;
			quality = Math.max(temp, 0);
		}
	}
}
