package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;

public interface Pricing {

    Price calculate(final Price price, final Quantity quantity, final ItemBuyMode itemBuyMode);
}
