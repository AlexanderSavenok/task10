package dataProviders;

import helpers.Randomize;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import parser.Parser;

import java.util.stream.Stream;

public class JsonDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        String firstFile = Randomize.randomFilePath(10);
        String secondFile = Randomize.randomFilePath(11);
        String thirdFile = Randomize.randomFilePath(12);
        String fourthFile = Randomize.randomFilePath(13);
        String fifthFile = Randomize.randomFilePath(14);

        return Stream.of(
                Arguments.of(firstFile), Arguments.of(secondFile), Arguments.of(thirdFile), Arguments.of(fourthFile),
                Arguments.of(fifthFile)
        );
    }
}
