package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Price;


public abstract class PackagePricing implements Pricing{

    protected Pricing pricing;

    public PackagePricing(final Pricing pricing){
        this.pricing = pricing;
    }

}
