import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTests {

    private static final String NAME = "PornHub Premium Account";
    private static final double PRICE = 124;
    private static final double SIZE_ON_DISK = 200000;
    private VirtualItem virtualItem;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        virtualItem = new VirtualItem();
        virtualItem.setName(NAME);
        virtualItem.setPrice(PRICE);
        virtualItem.setSizeOnDisk(SIZE_ON_DISK);
    }

    @Test(groups = {"VirtualItemTestsGroup", "MainGroup"})
    public void shouldReturnValidStringObjectRepresentingIfDataValidTest() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Size on disk: %s", VirtualItem.class.toString(), NAME, PRICE, SIZE_ON_DISK);
        String actualStringRepresenting = virtualItem.toString();

        Assert.assertEquals(expectedStringRepresenting, actualStringRepresenting, String.format("Expected string representing: %s\nActual string representing: %s", expectedStringRepresenting, actualStringRepresenting));
    }
}
