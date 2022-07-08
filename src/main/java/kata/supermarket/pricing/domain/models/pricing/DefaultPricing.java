package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;

public class DefaultPricing implements Pricing {
    Price price ;
    float qty;

    public DefaultPricing(Item item, float quantity) {

    }

    public void accept(final Item item, float qty){
        this.price = item.getPrice();
        this.qty = qty;
    }

    public Price calculate(){
        return new Price();
    }
}
