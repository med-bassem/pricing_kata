package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;


// Decorators parent class
public abstract class PriceCalculator implements Pricing{

    private Item item;
    private float qty;

    public PriceCalculator(final Item item, final float quantity){
        this.item = item ;
        this.qty = quantity ;
    }

    public abstract Price calculate();
}
