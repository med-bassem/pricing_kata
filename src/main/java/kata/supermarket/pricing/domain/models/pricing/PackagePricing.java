package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Price;


public abstract class PackagePricing implements Pricing{

    Pricing pricing;

    @Override
    public Price calculate(){
        return pricing.calculate();
    }
}
