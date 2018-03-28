import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTests {

    private final String name = "BMW";
    private final double price = 54242.4;
    private final double weight = 2000;
    private RealItem realItem;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        realItem = new RealItem();
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);
    }

    @Test(groups = {"RealItemTestsGroup", "MainGroup"})
    public void shouldReturnValidStringObjectRepresentingIfDataValidTest() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Weight: %s", RealItem.class.toString(), name, price, weight);
        String actualStringRepresenting = realItem.toString();

        Assert.assertEquals(expectedStringRepresenting, actualStringRepresenting, String.format("Expected string representing: %s\nActual string representing: %s", expectedStringRepresenting, actualStringRepresenting));
    }
}
