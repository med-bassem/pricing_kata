package kata.supermarket.pricing.domain.models;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    Integer id;

    Map<Item, Quantity> items = new HashMap<>();

    public boolean add(final Item item, final float quantity) throws ItemQuantityException {
        boolean isValidItem = validateItem(item);
        boolean isValidQty  = validateItemQuantity(item, quantity);

        if(isValidItem && isValidQty){
            items.merge(item, Quantity.of(quantity), (oldQuantity, v) -> Quantity.of(oldQuantity.amount() + quantity));
            return true ;
        }

        return false;
    }

    private boolean validateItemQuantity(Item item, float quantity) throws ItemQuantityException {
        if(BuyingMode.UNITARY == item.buyingMode && hasNoDecimals(quantity))
            return true;

        throw new ItemQuantityException(MessageFormat.format("Illegal quantity provided : {0} for Item {1}", quantity
                , item));
    }

    private boolean hasNoDecimals(float quantity) {
        return Math.ceil(quantity) == Math.floor(quantity);
    }

    private boolean validateItem(Item item) {
        boolean valid = true ;

        if(null == item){
            throw new NullPointerException("Item cant be null");
        }

        return valid;
    }

    public Map<Item, Quantity> getItems(){
        return Collections.unmodifiableMap(this.items);
    }


    public void checkout(){

    }
}
