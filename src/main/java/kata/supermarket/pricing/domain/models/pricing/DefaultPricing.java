package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPricing implements Pricing {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPricing.class);

    public Price calculate(final Price price, final Quantity quantity, final ItemBuyMode itemBuyMode){

        var result = Price.of(price.amount() * quantity.value());

        LOGGER.debug("Used default pricing for price: {}, qty: {}, buyingMode: {} = {}",
                price, quantity, itemBuyMode, result);

        return result;
    }
}
