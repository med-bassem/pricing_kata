package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.Price;

public class DefaultPricing implements Pricing {
    Pricing pricing ;

    public DefaultPricing(final Pricing pricing) {
        this.pricing = pricing;
    }

    /*
    public void accept(final Item item, float qty){
        this.price = item.getUnitPrice();
        this.qty = qty;
    }*/

    public Price calculate(){
        return Price.of(0);
        //return Price.of(price.amount() * qty);
    }
}
