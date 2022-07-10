package kata.supermarket.pricing.domain.models.pricing.methods;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import kata.supermarket.pricing.domain.models.pricing.PackagePricing;
import kata.supermarket.pricing.domain.models.pricing.PricingApplicability;

public class BuyTwoGetOne extends PackagePricing {

    public final PricingApplicability applicableTo = new PricingApplicability(Quantity.of(2), ItemBuyMode.UNITARY);

    public Price calculate(){
        return Price.of(0);
    }
}
