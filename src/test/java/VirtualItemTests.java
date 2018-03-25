import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("virtualItemPositiveTest")
public class VirtualItemTests {

    private static final String NAME = "PornHub Premium Account";
    private static final double PRICE = 124;
    private static final double SIZE_ON_DISK = 200000;
    private VirtualItem virtualItem;

    @BeforeEach
    public void init() {
        virtualItem = new VirtualItem();
        virtualItem.setName(NAME);
        virtualItem.setPrice(PRICE);
        virtualItem.setSizeOnDisk(SIZE_ON_DISK);
    }

    @Test
    public void shouldReturnValidStringObjectRepresentingIfDataValidTest() {
        String expectedStringRepresenting = String.format("Class: %s; Name: %s; Price: %s; Size on disk: %s", VirtualItem.class.toString(), NAME, PRICE, SIZE_ON_DISK);
        String actualStringRepresenting = virtualItem.toString();

        assertEquals(expectedStringRepresenting, actualStringRepresenting, String.format("Expected string representing: %d\nActual string representing: %d", expectedStringRepresenting, actualStringRepresenting));
    }
}
