package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;


// Decorators parent class
public abstract class PackagePricing implements Pricing{

    private Item item;
    private Quantity qty;

    public PackagePricing(final Item item, final Quantity quantity){
        this.item = item ;
        this.qty = quantity ;
    }

    public abstract Price calculate();
}
