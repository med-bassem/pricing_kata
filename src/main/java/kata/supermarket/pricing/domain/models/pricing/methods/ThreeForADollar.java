package kata.supermarket.pricing.domain.models.pricing.methods;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import kata.supermarket.pricing.domain.models.pricing.PackagePricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import kata.supermarket.pricing.domain.models.pricing.PricingApplicability;
import kata.supermarket.pricing.domain.models.pricing.PricingCalculation;

public class ThreeForADollar extends PackagePricing {

    private static final int APPLICABLE_QTY = 3;
    private static final int PACKAGE_PRICE  = 1;

    public ThreeForADollar(final Pricing pricing){
        super(pricing);
    }

    public Price calculate(final Price price, final Quantity quantity, final ItemBuyMode itemBuyMode){
        Price result = Price.ZERO;
        Quantity qty = Quantity.of(quantity.value());

        if(quantity.value()>=APPLICABLE_QTY){
            result = Price.of(PACKAGE_PRICE * ((int) quantity.value() / APPLICABLE_QTY ));
            qty = Quantity.of((int) quantity.value() % APPLICABLE_QTY);
        }

        result = Price.add(result, pricing.calculate(price, qty, itemBuyMode));

        return result;
    }
}
