package kata.supermarket.pricing.domain.models.pricing;

import kata.supermarket.pricing.domain.models.Item;

import java.util.HashSet;
import java.util.Set;

public class ItemValidator {

    public enum ItemValidation {
        CANT_BE_NULL("Item Cant be null");

        private final String message;

        ItemValidation(String message) {
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

    public Set<String> validate(final Item item){
        Set<String> result = new HashSet<>();

        if(null == item){
            result.add(ItemValidation.CANT_BE_NULL.message());
        }

        return result ;
    }
}
