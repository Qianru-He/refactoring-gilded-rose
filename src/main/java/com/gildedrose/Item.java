package com.gildedrose;

public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	public void updateQualityAndSellIn() {
		updateQuality();
		updateSellIn();
		if (isExpiration()) {
			updateQualityAfterExpiration();
		}
	}

	private void updateQualityAfterExpiration() {
		if (quality > 0) {
			quality -= 1;
		}
	}

	private boolean isExpiration() {
		return sellIn < 0;
	}

	protected void updateSellIn() {
		sellIn -= 1;
	}

	private void updateQuality() {
		updateQualityAfterExpiration();
	}
}
