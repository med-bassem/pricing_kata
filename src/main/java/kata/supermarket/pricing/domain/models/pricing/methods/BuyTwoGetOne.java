package kata.supermarket.pricing.domain.models.pricing.methods;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.Quantity;
import kata.supermarket.pricing.domain.models.pricing.PackagePricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BuyTwoGetOne extends PackagePricing {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyTwoGetOne.class);

    private static final int APPLICABLE_QTY = 2;
    private static final List<ItemBuyMode> applicableBuyModes = List.of(ItemBuyMode.UNITARY);

    public BuyTwoGetOne(final Pricing pricing){
        super(pricing);
    }

    public Price calculate(final Price price, final Quantity quantity, final ItemBuyMode itemBuyMode){
        Price result = Price.ZERO;
        Quantity qty = Quantity.of(quantity.value());

        if(quantity.value()>=APPLICABLE_QTY && applicableBuyModes.contains(itemBuyMode)){
            float packageQty = quantity.value() / APPLICABLE_QTY ;

            if(itemBuyMode == ItemBuyMode.UNITARY) {
                packageQty = (float) Math.floor(packageQty);
                qty = Quantity.of(quantity.value() % APPLICABLE_QTY);
            }

            result = Price.of(price.amount() * packageQty);

            LOGGER.debug("Used package pricing for price: {}, qty: {}, buyingMode: {} = {}",
                    price, quantity, itemBuyMode, result);
        }

        result = Price.add(result, pricing.calculate(price, qty, itemBuyMode));

        return result;
    }
}
