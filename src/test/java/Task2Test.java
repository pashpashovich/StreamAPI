import by.clevertec.Main;
import by.clevertec.model.Animal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Task2Test {

    private static List<Animal> animals;

    @BeforeAll
    static void setUp() {
        animals = Arrays.asList(
                new Animal(2, "Antelope, roan", 29, "Spanish", "Male"),
                new Animal(3, "Tern, arctic", 28, "Oriya", "Male"),
                new Animal(59, "Huron", 49, "Japanese", "Female"),
                new Animal(277, "Mourning collared dove", 31, "Japanese", "Male")
        );
    }

    @Test
    void testTask2WithNonEmptyArray() {
        List<String> expectedBreeds = Arrays.asList("HURON","Mourning collared dove");
        List<String> result = Main.task2(animals);
        assertEquals(expectedBreeds, result);
    }

}
