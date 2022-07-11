package kata.supermarket.pricing.domain.models.pricing.methods;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import kata.supermarket.pricing.domain.models.pricing.PackagePricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import kata.supermarket.pricing.domain.models.pricing.PricingApplicability;
import kata.supermarket.pricing.domain.models.pricing.PricingCalculation;

import java.util.List;

public class BuyTwoGetOne extends PackagePricing {

    private static final int APPLICABLE_QTY = 2;
    private static final List<ItemBuyMode> applicableBuyModes = List.of(ItemBuyMode.UNITARY);

    public BuyTwoGetOne(final Pricing pricing){
        super(pricing);
    }

    public Price calculate(final Price price, final Quantity quantity, final ItemBuyMode buyMode){
        Price result = Price.ZERO;
        Quantity qty = Quantity.of(quantity.value());

        if(quantity.value()>=APPLICABLE_QTY && applicableBuyModes.contains(buyMode)){
            result = Price.of(price.amount() * ((int) quantity.value() / APPLICABLE_QTY ));
            qty = Quantity.of((int) quantity.value() %2);
        }

        result = Price.add(result, pricing.calculate(price, qty, buyMode));

        return result;
    }
}
