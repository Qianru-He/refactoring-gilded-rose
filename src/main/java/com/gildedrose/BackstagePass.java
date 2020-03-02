package com.gildedrose;

public class BackstagePass extends Item {
	public BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		if (quality < 50) {
			quality += 1;
			if (sellIn < 11 && quality < 50) {
				quality += 1;
			}
			if (sellIn < 6 && quality < 50) {
				quality += 1;
			}
		}
		sellIn -= 1;
		if (sellIn < 0) {
			quality = 0;
		}
	}
}
