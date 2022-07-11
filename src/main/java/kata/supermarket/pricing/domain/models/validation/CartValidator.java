package kata.supermarket.pricing.domain.models.validation;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.exceptions.ItemQuantityException;

import static java.text.MessageFormat.format;

public class CartValidator {

    public static boolean validateItemQuantity(Item item, float quantity) throws ItemQuantityException {
        boolean valid = true ;

        if(!(ItemBuyMode.UNITARY == item.getBuyingMode() && hasNoDecimals(quantity))) {
            throw new ItemQuantityException(format("Illegal quantity: {0} for Item: {1}", quantity, item));
        }


        return valid ;
    }

    private static boolean hasNoDecimals(float quantity) {
        return Math.ceil(quantity) == Math.floor(quantity);
    }

    public static boolean validateItem(Item item) {
        var errors = ItemValidator.validate(item);

        return errors.isEmpty();
    }
}
