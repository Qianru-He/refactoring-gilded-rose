package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int temp = quality - 1;
        quality = Math.max(temp, 0);
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            temp = quality - 1;
            quality = Math.max(temp, 0);
        }
    }
}
