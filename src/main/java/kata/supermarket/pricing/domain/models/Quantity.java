package kata.supermarket.pricing.domain.models;

import java.util.Objects;

/**
 * Value Object class for Quantity
 */
public class Quantity {

    private final float value ;

    private Quantity(float value) {
        this.value = value;
    }

    public float value(){
        return value;
    }

    public static Quantity of(final float value){
        return new Quantity(value);
    }

    public static Quantity add(final Quantity arg1, final Quantity arg2){
        if(null == arg1) {
            throw new NullPointerException("First 'Quantity' argument for addition cant be null");
        }

        if(null == arg2) {
            throw new NullPointerException("Second 'Quantity' argument for addition cant be null");
        }

        return Quantity.of(arg1.value + arg2.value);
    }

    public static Quantity substract(final Quantity arg1, final Quantity arg2) {

        if (null == arg1) {
            throw new NullPointerException("First 'Quantity' argument for substraction cant be null");
        }

        if (null == arg2) {
            throw new NullPointerException("Second 'Quantity' argument to be substracted cant be null");
        }

        if (arg1.value <= arg2.value) {
            throw new IllegalArgumentException("Cant have a negative result for quantity substraction");
        }

        return Quantity.of(arg1.value - arg2.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return Float.compare(quantity.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + "" ;
    }
}
