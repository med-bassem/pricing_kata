package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;

public class PackagePricing extends PriceCalculator {

    public PackagePricing(final Item item, final float quantity){
        super(item, quantity);
    }

    @Override
    public Price calculate() {
        return null;
    }
}
