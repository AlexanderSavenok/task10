package dataProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import parser.Parser;

import java.util.stream.Stream;

public class JsonDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        Parser firstParser = null;
        Parser secondParser = null;
        Parser thirdParser = null;
        Parser fourthParser = null;
        Parser fifthParser = null;

        return Stream.of(
                Arguments.of(firstParser), Arguments.of(secondParser), Arguments.of(thirdParser), Arguments.of(fourthParser),
                Arguments.of(fifthParser)
        );
    }
}
