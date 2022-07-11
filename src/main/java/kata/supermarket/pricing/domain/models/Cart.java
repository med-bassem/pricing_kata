package kata.supermarket.pricing.domain.models;

import kata.supermarket.pricing.domain.models.exceptions.ItemQuantityException;
import kata.supermarket.pricing.domain.models.pricing.DefaultPricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import kata.supermarket.pricing.domain.models.validation.CartValidator;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Cart {

    Map<Item, Quantity> content = new HashMap<>();

    public boolean add(final Item item, final float quantity) throws ItemQuantityException {
        boolean isValidItem = CartValidator.validateItem(item);
        boolean isValidQty  = CartValidator.validateItemQuantity(item, quantity);

        if(isValidItem && isValidQty){
            content.merge(item, Quantity.of(quantity), (oldQuantity, v) -> Quantity.of(oldQuantity.value() + quantity));
            return true ;
        }

        return false;
    }

    public Map<Item, Quantity> getContent(){
        return Collections.unmodifiableMap(this.content);
    }


    public Price checkout(final Map<Item, Pricing> pricings) {
        CartValidator.validatePricings(pricings);

        AtomicReference<Price> total = new AtomicReference<>(Price.ZERO);

        content.forEach((item, quantity) -> {
                Pricing pricing = findPricing(item, pricings);
                var price = pricing.calculate(item.getBasePrice(), quantity, item.getBuyingMode());
                total.set(Price.add(total.get(), price));
            }
        );

        return total.get();
    }

    private Pricing findPricing(final Item item, final Map<Item, Pricing> pricings) {

        var op = pricings.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(item))
                .filter(e -> e.getValue() != null)
                .findFirst();

        if(op.isPresent()){
            return op.get().getValue();
        }

        return new DefaultPricing();
    }
}
