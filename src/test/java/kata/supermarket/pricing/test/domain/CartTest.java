package kata.supermarket.pricing.test.domain;

import kata.supermarket.pricing.domain.models.BuyingMode;
import kata.supermarket.pricing.domain.models.Cart;
import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.ItemQuantityException;
import kata.supermarket.pricing.domain.models.Price;
import org.junit.jupiter.api.Test;

class CartTest {

    @Test
    void GivenCart_shouldAddItem() throws ItemQuantityException {
        Item item = new Item("foo", Price.of(0), BuyingMode.UNITARY);
        Cart cart = new Cart();
        cart.add(item,2);

    }

}
