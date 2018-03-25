import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("realItemPositiveTest")
public class RealItemTests {

    private final String name = "BMW";
    private final double price = 54242.4;
    private final double weight = 2000;
    private RealItem realItem;

    @BeforeEach
    public void init() {
        realItem = new RealItem();
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);
    }

    @Test
    public void shouldReturnValidStringObjectRepresentingIfDataValidTest() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Weight: %s", RealItem.class.toString(), name, price, weight);
        String actualStringRepresenting = realItem.toString();

        assertEquals(expectedStringRepresenting, actualStringRepresenting, String.format("Expected string representing: %d\nActual string representing: %d", expectedStringRepresenting, actualStringRepresenting));
    }
}
