package kata.supermarket.pricing.test.domain;

import kata.supermarket.pricing.domain.models.ItemBuyMode;
import kata.supermarket.pricing.domain.models.Cart;
import kata.supermarket.pricing.domain.models.Item;
import kata.supermarket.pricing.domain.models.exceptions.ItemQuantityException;
import kata.supermarket.pricing.domain.models.Price;
import kata.supermarket.pricing.domain.models.pricing.DefaultPricing;
import kata.supermarket.pricing.domain.models.pricing.Pricing;
import kata.supermarket.pricing.domain.models.pricing.methods.BuyTwoGetOne;
import kata.supermarket.pricing.domain.models.pricing.methods.ThreeForADollar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartTest {

    @Test
    void GivenCart_shouldAddItems() throws ItemQuantityException {
        Item item = new Item("foo", Price.of(1), ItemBuyMode.UNITARY);
        Item item2 = new Item("bar", Price.of(2), ItemBuyMode.UNITARY);
        Cart cart = new Cart();

        cart.add(item,2);
        cart.add(item2, 2);

        assertEquals(2, cart.getContent().size());
        assertTrue(cart.getContent().containsKey(item));
        assertTrue(cart.getContent().containsKey(item2));
    }

    @Test
    void GivenDefaultPrice_shouldCheckoutOK() throws ItemQuantityException {
        Item item = new Item("foo", Price.of(1), ItemBuyMode.UNITARY);
        Item item2 = new Item("bar", Price.of(2), ItemBuyMode.UNITARY);

        Cart cart = new Cart();
        cart.add(item, 10);
        cart.add(item2, 5);

        Map<Item, Pricing> pricings = new HashMap<>();
        Pricing pricing = new DefaultPricing();
        pricings.put(item, pricing);
        pricings.put(item2, pricing);

        Price total = cart.checkout(pricings);

        assertEquals(20, total.amount());
    }

    @Test
    void GivenPackagePrice_shouldCheckoutOK() throws ItemQuantityException {
        Item item = new Item("foo", Price.of(4), ItemBuyMode.UNITARY);
        Item item2 = new Item("bar", Price.of(2), ItemBuyMode.UNITARY);

        Cart cart = new Cart();
        cart.add(item, 10);
        cart.add(item2, 5);

        Map<Item, Pricing> pricings = new HashMap<>();
        Pricing defaultPricing = new DefaultPricing();
        pricings.put(item, new ThreeForADollar(defaultPricing));
        pricings.put(item2, new BuyTwoGetOne(defaultPricing));

        Price total = cart.checkout(pricings);

        assertEquals(13, total.amount());
    }

    @Test
    void GivenIllegalQuantity_shouldThrowException() {
        Item item = new Item("foo", Price.of(1), ItemBuyMode.UNITARY);
        Cart cart = new Cart();

        assertThrows(ItemQuantityException.class, ()-> cart.add(item, 1.5f));
    }

    @Test
    void GivenNullPricings_shouldThrowException() {
        Cart cart = new Cart();

        assertThrows(NullPointerException.class, ()-> cart.checkout(null));
    }

}
