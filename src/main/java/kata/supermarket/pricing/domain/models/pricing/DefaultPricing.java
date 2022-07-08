package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.Price;

public class DefaultPricing implements Pricing {
    Price price ;
    float qty;

    public DefaultPricing(Item item, float quantity) {

    }

    public void accept(final Item item, float qty){
        this.price = item.getUnitPrice();
        this.qty = qty;
    }

    public Price calculate(){
        return Price.of(price.amount() * qty);
    }
}
