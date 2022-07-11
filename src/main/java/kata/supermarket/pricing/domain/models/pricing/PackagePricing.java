package kata.supermarket.pricing.domain.models.pricing;


public abstract class PackagePricing implements Pricing{

    protected Pricing pricing;

    protected PackagePricing(final Pricing pricing){
        this.pricing = pricing;
    }

}
