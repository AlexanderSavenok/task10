package dataProviders;

import helpers.Randomize;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {
    @DataProvider(name = "filePaths")
    public static Object[][] createRandomFilePathData() {
        return new Object[][] {
                new Object[] {Randomize.randomFilePath(10)}, new Object[] {Randomize.randomFilePath(11)},
                new Object[] {Randomize.randomFilePath(12)}, new Object[] {Randomize.randomFilePath(13)},
                new Object[] {Randomize.randomFilePath(14)}, new Object[] {Randomize.randomFilePath(15)}
        };
    }

}
