import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A list")
@DisplayNameGeneration(ReplaceUnderscores.class)
class Exercise04_ListTests {

    List<String> list = new ArrayList<>();

    @Test
    void is_empty_after_creation() {
        assertTrue(list.isEmpty());
    }

    @Test
    void throws_exception_when_getting_missing_element() {
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Nested
    @DisplayName("with one element")
    class OneElement {

        @BeforeEach
        void addFirstElement() {
            list.add("first");
        }

        @Test
        void returns_first_element() {
            assertEquals("first", list.getFirst());
        }

        @Test
        void has_size_of_1() {
            assertEquals(1, list.size());
        }

        @Nested
        class TwoElements {
            @BeforeEach
            void addSecondElement() {
                list.add("second");
            }

            @Test
            void returns_first_element() {
                assertEquals("first", list.getFirst());
            }

            @Test
            void returns_last_element() {
                assertEquals("second", list.getLast());
            }

            @Test
            void has_size_of_2() {
                assertEquals(2, list.size());
            }
        }
    }
}
