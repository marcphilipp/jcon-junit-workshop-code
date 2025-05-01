import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(NotTodayExtension.class)
class Exercise08_Tests {

    @NotToday
    @Test
    void test() {
        fail("should not be executed today");
    }
}
