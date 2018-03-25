import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("cartPositiveTest")
public class CartTests {

    private static final String CART_NAME = "TestCart";
    private static final String REAL_ITEM_NAME = "Car";
    private static final String VIRTUAL_ITEM_NAME = "Premium Account";
    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeEach
    public void init() {
        cart = new Cart(CART_NAME);
        realItem = new RealItem();
        virtualItem = new VirtualItem();
        realItem.setName(REAL_ITEM_NAME);
        virtualItem.setName(VIRTUAL_ITEM_NAME);
    }

    @Test
    public void shouldCalculateTotalPriceIfDataValid_Test() {
        double realItemPrice = 45;
        double virtualItemPrice = 90;
        double tax = 0.2;
        double expectedTotalPrice = (realItemPrice + realItemPrice * tax) + (virtualItemPrice + virtualItemPrice * tax);
        realItem.setPrice(realItemPrice);
        virtualItem.setPrice(virtualItemPrice);

        cart.addVirtualItem(virtualItem);
        cart.addRealItem(realItem);
        double totalPrice = cart.getTotalPrice();

        assertEquals(expectedTotalPrice, totalPrice, String.format("Expected total price: %.2f\nActual total price: %.2f", expectedTotalPrice, totalPrice));
        //this scenario could be right for unit tests?
    }

    @Test
    public void shouldReturnZeroTotalPriceValueIfRealItemPriceAbsentTest() {
        cart.addRealItem(realItem);
        double totalPrice = cart.getTotalPrice();

        assertEquals(0, totalPrice, String.format("Expected total price: %n\nActual total price: %n", 0, totalPrice));
        //this scenario could be right for unit tests?
    }

    @Test
    public void shouldReturnZeroTotalPriceValueIfVirtualItemPriceAbsentTest() {
        cart.addVirtualItem(virtualItem);
        double totalPrice = cart.getTotalPrice();

        assertEquals(0, totalPrice, String.format("Expected total price: %n\nActual total price: %n", 0, totalPrice));
        //this scenario could be right for unit tests?
    }
}
