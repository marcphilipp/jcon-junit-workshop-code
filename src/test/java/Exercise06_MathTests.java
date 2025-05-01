import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Exercise06_MathTests {

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            " 1, 1.00",
            " 2, 1.41",
            " 4, 2.00",
    })
    void sqrt(double input, double expectedOutput) {
        assertEquals(expectedOutput, Math.sqrt(input), 0.01);
    }

    @ParameterizedTest(name = "floor({0}) = {1}")
    @MethodSource
    void floor(double input, int expectedOutput) {
        assertEquals(expectedOutput, Math.floor(input), 0.01);
    }

    static Stream<Arguments> floor() {
        return Stream.of(
                arguments(+1.1d, +1),
                arguments(-1.1d, -2)
        );
    }
}
