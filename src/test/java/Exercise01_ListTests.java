import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

class Exercise01_ListTests {

    @Disabled("missing assertion")
    @Test
    void is_empty_after_creation() {
        List<String> list = new ArrayList<>();

        // TODO write correct assertion
        fail("missing assertion");
    }

    @Disabled("missing assertion")
    @Test
    void throws_exception_when_getting_missing_element() {
        List<String> list = new ArrayList<>();

        // TODO write correct assertion
        list.get(0);
    }

    // TODO fix me
    @Disabled("needs to be fixed")
    @Test
    void has_size_of_one_after_adding_an_element() {
        List<String> list = new ArrayList<>();
        list.add("item");

        assertSame("item", list.get(0));
        assertEquals(42, list.size());
    }

}
