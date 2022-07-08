package kata.supermarket.pricing.test.domain;

import kata.supermarket.pricing.domain.models.Cart;
import kata.supermarket.pricing.domain.models.Item;
import org.junit.jupiter.api.Test;

class CartTest {

    @Test
    void GivenCart_shouldAddItem(){
        Item item = new Item();
        Cart cart = new Cart();
        cart.add(item,2);

    }

}
