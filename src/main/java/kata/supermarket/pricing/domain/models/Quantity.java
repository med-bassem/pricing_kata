package kata.supermarket.pricing.domain.models;

/**
 * Value Object class for Quantity
 */
public class Quantity {

    private final float amount ;

    private Quantity(float amount) {
        this.amount = amount;
    }

    public float amount(){
        return amount;
    }

    public static Quantity of(final float amount){
        return new Quantity(amount);
    }

    public static Quantity add(final Quantity arg1, final Quantity arg2){
        if(null == arg1) {
            throw new NullPointerException("First 'Quantity' argument for addition cant be null");
        }

        if(null == arg2) {
            throw new NullPointerException("Second 'Quantity' argument for addition cant be null");
        }

        return Quantity.of(arg1.amount + arg2.amount);
    }

    public static Quantity substract(final Quantity arg1, final Quantity arg2) {

        if (null == arg1) {
            throw new NullPointerException("First 'Quantity' argument for substraction cant be null");
        }

        if (null == arg2) {
            throw new NullPointerException("Second 'Quantity' argument to be substracted cant be null")
        }

        if (arg1.amount <= arg2.amount) {
            throw new IllegalArgumentException("Cant have a negative result for quantity substraction");
        }

        return Quantity.of(arg1.amount - arg2.amount);
    }

    public boolean equals(final Quantity arg1, final Quantity arg2) {
        if (null == arg1) {
            throw new NullPointerException("First 'Quantity' argument for equality cant be null");
        }

        if (null == arg2) {
            throw new NullPointerException("Second 'Quantity' argument for equality cant be null");
        }

        return arg1.amount == arg2.amount ;

    }


}
