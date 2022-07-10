package kata.supermarket.pricing.domain.models.pricing.methods;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import kata.supermarket.pricing.domain.models.pricing.PricingApplicability;

public class ThreeForADollar {

    private static final PricingApplicability applicableTo = new PricingApplicability(Quantity.of(3),
            ItemBuyMode.UNITARY);


    public Price calculate(){
        return Price.of(1);
    }
}
