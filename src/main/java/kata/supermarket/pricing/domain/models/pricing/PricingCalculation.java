package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;

public class PricingCalculation {

    private final Price price;
    private final Quantity remainingQty;

    public PricingCalculation(final Price price, final Quantity remainingQty) {
        this.price = price;
        this.remainingQty = remainingQty;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getRemainingQuantity() {
        return remainingQty;
    }
}
