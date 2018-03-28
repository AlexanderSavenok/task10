import dataProviders.JsonDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

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

    @BeforeMethod(alwaysRun = true)
    public void init() {
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        fileName = "TestFileName_" + timeStamp;
        filePath = "src/main/resources/" + fileName + ".json";
        fileToImport = new File(filePath);
        parser = new JsonParser();
    }

    @Test(dataProvider = "filePaths", dataProviderClass = JsonDataProvider.class, groups = {"JsonParserTestsGroup", "MainGroup"})
    //@Parameters({"invalidPath"}) //This for testng.xml configuration file with parameters
    public void shouldHandleNoSuchExceptionIfFileNotExistTest(String filePath) {
        parser = new JsonParser();

        assertThrows(NoSuchFileException.class, () -> {parser.readFromFile(new File(filePath));});
    }

    @Test(enabled = false, groups = {"JsonParserTestsGroup", "disabled", "MainGroup"})
    public void shouldCreateJsonFileIfDataValidTest() {
        cart = createCartWithRealItem(fileName, REAL_ITEM_NAME, PRICE, WEIGHT);

        parser = new JsonParser();
        parser.writeToFile(cart);

        assertTrue(fileToImport.exists(), "Json file was not written");
    }

    @Test(groups = {"JsonParserTestsGroup", "MainGroup"})
    public void shouldParseDataFromFileIfFileExistsTest() {
        String fileName = "TestFileName_ReadMethod";
        String filePath = String.format("src/main/resources/%s" + ".json", fileName);
        double expectedTotalPrice = 31200.0;

        parser = new JsonParser();
        Cart dataFromFile = parser.readFromFile(new File(filePath));
        double actualDataPrice = dataFromFile.getTotalPrice();

        assertEquals(expectedTotalPrice, actualDataPrice, String.format("Expected total price: %n\nActual total price: %n", expectedTotalPrice, actualDataPrice));
    }

    @AfterMethod(alwaysRun = true)
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
