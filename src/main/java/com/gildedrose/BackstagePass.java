package com.gildedrose;

public class BackstagePass extends Item {
	public BackstagePass(int sellIn, int quality) {
		super("BackstagePasses", sellIn, quality);
	}

	@Override
	public void updateQualityAndSellIn() {
		if (quality < 50) {
			quality += 1;
			if (sellIn < 11 && quality < 50) {
				quality += 1;
			}
			if (sellIn < 6 && quality < 50) {
				quality += 1;
			}
		}
		updateSellIn();
		if (sellIn < 0) {
			quality = 0;
		}
	}
}
