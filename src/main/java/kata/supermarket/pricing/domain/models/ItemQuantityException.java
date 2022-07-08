package kata.supermarket.pricing.domain.models;

public class ItemQuantityException extends Exception {
    public ItemQuantityException(final String message){
        super(message);
    }

}
