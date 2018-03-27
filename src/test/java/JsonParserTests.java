import dataProviders.JsonDataProvider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParserTests {

    private static final String REAL_ITEM_NAME = "Jeely Atlas";
    private static final double PRICE = 26000;
    private static final double WEIGHT = 2000;
    private String timeStamp;
    private File fileToImport;
    private String fileName;
    private String filePath;
    private Parser parser;
    private Cart cart;

    @BeforeEach
    public void init() {
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        fileName = "TestFileName_" + timeStamp;
        filePath = "src/main/resources/" + fileName + ".json";
        fileToImport = new File(filePath);
        parser = new JsonParser();
    }

    @Tag("jsonParserExceptionTest")
    @DisplayName("Should pass a nonexistent file to this test method")
    @ParameterizedTest(name = "{index} => File name = ''{0}''")
    @ArgumentsSource(JsonDataProvider.class)
    public void shouldHandleNoSuchExceptionIfFileNotExistTest(String filePath) {
        parser = new JsonParser();

        assertThrows(NoSuchFileException.class, () -> {parser.readFromFile(new File(filePath));});
    }

    @Test
    @Tag("jsonParserPositiveTest")
    @Disabled
    public void shouldCreateJsonFileIfDataValidTest() {
        cart = createCartWithRealItem(fileName, REAL_ITEM_NAME, PRICE, WEIGHT);

        parser = new JsonParser();
        parser.writeToFile(cart);

        assertTrue(fileToImport.exists(), "Json file was not written");
    }

    @Test
    @Tag("jsonParserPositiveTest")
    public void shouldParseDataFromFileIfFileExistsTest() {
        String fileName = "TestFileName_ReadMethod";
        String filePath = String.format("src/main/resources/%s" + ".json", fileName);
        double expectedTotalPrice = 31200.0;

        parser = new JsonParser();
        Cart dataFromFile = parser.readFromFile(new File(filePath));
        double actualDataPrice = dataFromFile.getTotalPrice();

        assertEquals(expectedTotalPrice, actualDataPrice, String.format("Expected total price: %n\nActual total price: %n", expectedTotalPrice, actualDataPrice));
    }

    @AfterEach
    public void tearDown() {
        fileToImport.delete();
    }

    private Cart createCartWithRealItem(String cartName, String realItemName, double price, double weight) {
        Cart cart = new Cart(cartName);
        RealItem realItem = new RealItem();
        realItem.setName(realItemName);
        realItem.setPrice(price);
        realItem.setWeight(weight);
        cart.addRealItem(realItem);

        return cart;
    }
}
