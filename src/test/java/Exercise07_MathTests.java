import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise07_MathTests {

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
            " 1, 1.00",
            " 2, 1.41"
    })
    void sqrt(double input, double expectedOutput) {
        assertEquals(expectedOutput, Math.sqrt(input), 0.01);
    }
}
