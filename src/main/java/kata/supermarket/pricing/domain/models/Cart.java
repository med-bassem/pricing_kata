package kata.supermarket.pricing.domain.models;

import kata.supermarket.pricing.domain.models.pricing.PackagePricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import kata.supermarket.pricing.domain.models.validation.CartValidator;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    Integer id;

    Map<Item, Quantity> items = new HashMap<>();
    Map<Item, Pricing>  pricings = new HashMap<>();

    public boolean add(final Item item, final float quantity) throws ItemQuantityException {
        boolean isValidItem = CartValidator.validateItem(item);
        boolean isValidQty  = CartValidator.validateItemQuantity(item, quantity);

        if(isValidItem && isValidQty){
            items.merge(item, Quantity.of(quantity), (oldQuantity, v) -> Quantity.of(oldQuantity.value() + quantity));
            return true ;
        }

        return false;
    }

    public boolean addPackagePricing(final Item item, final PackagePricing pricing){
        pricings.putIfAbsent(item, pricing);

        return true ;
    }



    public Map<Item, Quantity> getItems(){
        return Collections.unmodifiableMap(this.items);
    }


    public void checkout(){

    }
}
