package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;


public abstract class PackagePricing implements Pricing{

    Pricing pricing;

    @Override
    public Price calculate(){
        return pricing.calculate();
    }
}
