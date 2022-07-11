package kata.supermarket.pricing.domain.models.validation;

import kata.supermarket.pricing.domain.models.Item;

import java.util.HashSet;
import java.util.Set;

public class ItemValidator {

    public enum ItemValidatorErr {
        CANT_BE_NULL("Item Cant be null");

        private final String message;

        ItemValidatorErr(String message) {
            this.message = message ;
        }

        public String message(){
            return message ;
        }

        @Override
        public String toString() {
            return message ;
        }
    }

    public static Set<String> validate(final Item item){
        Set<String> result = new HashSet<>();

        if(null == item){
            result.add(ItemValidatorErr.CANT_BE_NULL.message());
        }

        return result ;
    }
}
