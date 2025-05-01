import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Disabled // TODO remove me
class Exercise09_Tests {

    @NotToday
    @Test
    void test() {
        fail("should not be executed today");
    }
}
