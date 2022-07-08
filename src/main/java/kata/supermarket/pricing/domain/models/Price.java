package kata.supermarket.pricing.domain.models;

/**
 * Value Object class for Price
 */
public class Price {
    private final float amount ;

    private Price(float amount) {
        this.amount = amount;
    }

    public float amount(){
        return amount;
    }

    public static Price of(final float amount){
        return new Price(amount);
    }

    public static Price add(final Price arg1, final Price arg2){
        if(null == arg1) {
            throw new NullPointerException("First 'Price' argument for addition cant be null");
        }

        if(null == arg2) {
            throw new NullPointerException("Second 'Price' argument for addition cant be null");
        }

        return Price.of(arg1.amount + arg2.amount);
    }

    public static Price substract(final Price arg1, final Price arg2) {

        if (null == arg1) {
            throw new NullPointerException("First 'Price' argument for substraction cant be null");
        }

        if (null == arg2) {
            throw new NullPointerException("Second 'Price' argument to be substracted cant be null");
        }

        if (arg1.amount <= arg2.amount) {
            throw new IllegalArgumentException("Cant have a negative result for Price substraction");
        }

        return Price.of(arg1.amount - arg2.amount);
    }

    public boolean equal(final Price arg1, final Price arg2) {

        if (null == arg1) {
            throw new NullPointerException("First 'Price' argument for equality cant be null");
        }

        if (null == arg2) {
            throw new NullPointerException("Second 'Price' argument for equality cant be null");
        }

        return arg1.amount == arg2.amount ;

    }
}
