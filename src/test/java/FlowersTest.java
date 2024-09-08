import by.clevertec.Main;
import by.clevertec.model.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlowersTest {

    private static List<Flower> flowers;

    @BeforeEach
    void setUp() {
        flowers = Arrays.asList(
                new Flower(10, "Long-scape Iris", "Iridaceae", 1.67, true, "Central", 968, Arrays.asList("Plexiglass", "Rubber", "Stone", "Granite", "Brass", "Granite", "Granite")),
                new Flower(15, "Himalayan Honeysuckle", "Caprifoliaceae", 0.46, false, "Central African Republic", 82, Arrays.asList("Brass", "Wood", "Brass", "Aluminum", "Steel", "Steel", "Vinyl")),
                new Flower(36, "Fries' Dimple Lichen", "Gyalectaceae", 6.25, false, "Central African Republic", 789, Arrays.asList("Plastic", "Stone", "Plastic", "Granite", "Steel", "Steel", "Aluminum")),
                new Flower(65, "Waxflower", "Zingiberaceae", 5.04, false, "Central African Republic", 998, Arrays.asList("Brass", "Glass", "Wood", "Brass", "Vinyl", "Glass", "Vinyl")),
                new Flower(86, "Alifornia Bedstraw", "Rubiaceae", 5.66, true, "Central African Republic", 1481, Arrays.asList("Stone", "Plastic", "Plexiglass", "Plexiglass", "Brass", "Glass", "Steel"))
        );
    }

    @Test
    void Task15() {
        double expectedResult = 1481 + 1.39 * (365 * 4 + 366) * 5.66;
        double result = Main.task15(flowers);
        assertEquals(Math.round(expectedResult), Math.round(result));
    }
}
