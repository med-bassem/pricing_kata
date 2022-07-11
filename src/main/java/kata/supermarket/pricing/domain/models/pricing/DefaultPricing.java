package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;

public class DefaultPricing implements Pricing {

    public Price calculate(final Price price, final Quantity quantity, final ItemBuyMode itemBuyMode){
        return Price.of(price.amount() * quantity.value());
    }
}
