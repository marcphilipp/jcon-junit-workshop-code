import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class Exercise08_Tests {

    @NotToday
    @Test
    void test() {
        fail("should not be executed today");
    }
}
