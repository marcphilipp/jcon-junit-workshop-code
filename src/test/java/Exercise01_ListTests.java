import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A list")
class Exercise01_ListTests {

    List<String> list;

    @BeforeEach
    void createList() {
        list = new ArrayList<>();
    }

    @Test
    @Tag("exercise-3")
    void is_empty_after_creation() {
        assertTrue(list.isEmpty());
    }

    @Test
    void throws_exception_when_getting_missing_element() {
        assertThrows(NoSuchElementException.class, list::getFirst);
    }

    @Test
    @Tag("exercise-3")
    void has_size_of_one_after_adding_an_element() {
        list.add("item");

        assertSame("item", list.getFirst());
        assertEquals(1, list.size());
    }

}
