package kata.supermarket.pricing.domain.models;

import kata.supermarket.pricing.domain.models.pricing.Price;

public class Item {
    Integer id;

    String name;

    Price unitPrice;

    BuyingMode buyingMode;

    public Price getPrice() {
        return unitPrice;
    }
}
