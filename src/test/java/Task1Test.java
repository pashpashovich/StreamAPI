import by.clevertec.Main;
import by.clevertec.model.Animal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    private static List<Animal> animals;

    @BeforeAll
    static void setUp() {
        animals = Arrays.asList(
                new Animal(2, "Antelope, roan", 29, "Spanish", "Male"),
                new Animal(3, "Tern, arctic", 28, "Oriya", "Male"),
                new Animal(4, "White-throated toucan", 18, "Tswana", "Female"),
                new Animal(5, "Legaan, Monitor (unidentified)", 15, "Guaraní", "Male"),
                new Animal(6, "Javan gold-spotted mongoose", 33, "Kurdish", "Male"),
                new Animal(7, "Southern boubou", 45, "Sotho", "Female"),
                new Animal(8, "Starling, red-shouldered glossy", 17, "Pashto", "Male"),
                new Animal(9, "Field flicker", 34, "Catalan", "Female"),
                new Animal(10, "Huron", 46, "Ndebele", "Female"),
                new Animal(11, "House sparrow", 34, "Azeri", "Male"),
                new Animal(12, "Oystercatcher, blackish", 45, "Hungarian", "Male"),
                new Animal(13, "Baboon, chacma", 43, "Fijian", "Male"),
                new Animal(14, "Stork, woolly-necked", 37, "Kurdish", "Male"),
                new Animal(15, "Little cormorant", 32, "Lao", "Female"),
                new Animal(16, "Ovenbird", 25, "Malay", "Female"),
                new Animal(17, "Cook's tree boa", 9, "Bengali", "Male"),
                new Animal(18, "Heron, little", 10, "Gujarati", "Male"),
                new Animal(19, "Mudskipper (unidentified)", 25, "Hungarian", "Female"),
                new Animal(20, "Sandpiper, spotted wood", 45, "Kazakh", "Male"),
                new Animal(21, "Barasingha deer", 34, "Aymara", "Genderfluid"),
                new Animal(22, "African darter", 37, "Malagasy", "Male"),
                new Animal(23, "African wild dog", 8, "Italian", "Male"),
                new Animal(24, "Komodo dragon", 20, "Bislama", "Genderqueer"),
                new Animal(25, "Bush dog", 44, "Greek", "Female"),
                new Animal(26, "African wild cat", 19, "Afrikaans", "Female"),
                new Animal(27, "Quail, gambel's", 5, "Indonesian", "Female"),
                new Animal(28, "Jackal, indian", 48, "Nepali", "Female"),
                new Animal(29, "Mudskipper (unidentified)", 11, "German", "Male"),
                new Animal(30, "Bobcat", 46, "Khmer", "Male"),
                new Animal(31, "Squirrel, smith's bush", 41, "French", "Male"),
                new Animal(32, "Wallaroo, common", 27, "West Frisian", "Male"),
                new Animal(33, "Comb duck", 22, "Spanish", "Male"),
                new Animal(34, "Red-tailed cockatoo", 19, "Dhivehi", "Female"),
                new Animal(35, "Tern, arctic", 26, "Korean", "Female"),
                new Animal(36, "Short-beaked echidna", 8, "Moldovan", "Male"),
                new Animal(37, "Ringtail, common", 40, "Oriya", "Non-binary"),
                new Animal(38, "Red-billed buffalo weaver", 9, "Oriya", "Female"),
                new Animal(39, "Dog, black-tailed prairie", 13, "Moldovan", "Female"),
                new Animal(40, "Turtle, snake-necked", 1, "Tok Pisin", "Female"),
                new Animal(41, "Deer, red", 49, "Kannada", "Male"),
                new Animal(42, "Saddle-billed stork", 21, "Ndebele", "Female"),
                new Animal(43, "Desert kangaroo rat", 29, "Norwegian", "Male"),
                new Animal(44, "Black-footed ferret", 48, "Kannada", "Female"),
                new Animal(45, "Dove, little brown", 43, "Afrikaans", "Female"),
                new Animal(46, "Dragon, frilled", 46, "Kashmiri", "Male"),
                new Animal(47, "Tamandua, southern", 20, "Ndebele", "Male"),
                new Animal(48, "Superb starling", 2, "Indonesian", "Male"),
                new Animal(49, "Rabbit, eastern cottontail", 32, "Bengali", "Male"),
                new Animal(50, "Frilled lizard", 39, "Dzongkha", "Male"),
                new Animal(51, "Mourning collared dove", 38, "Tok Pisin", "Female"),
                new Animal(52, "Laughing dove", 17, "Haitian Creole", "Male"),
                new Animal(53, "Baboon, olive", 21, "Croatian", "Female"),
                new Animal(54, "Western palm tanager (unidentified)", 22, "Moldovan", "Female"),
                new Animal(55, "Malay squirrel (unidentified)", 40, "Quechua", "Female"),
                new Animal(56, "Anaconda (unidentified)", 31, "Nepali", "Male"),
                new Animal(57, "Nighthawk, common", 12, "Moldovan", "Male"),
                new Animal(58, "Whale, long-finned pilot", 38, "Tok Pisin", "Female"),
                new Animal(59, "Huron", 49, "Japanese", "Female"),
                new Animal(60, "Chacma baboon", 12, "Spanish", "Male"),
                new Animal(61, "Ornate rock dragon", 30, "Afrikaans", "Female"),
                new Animal(62, "Wallaroo, common", 22, "Fijian", "Male"),
                new Animal(63, "Duck, blue", 11, "Czech", "Male"),
                new Animal(64, "Peregrine falcon", 19, "Estonian", "Female"),
                new Animal(65, "Lemur, lesser mouse", 15, "Kurdish", "Male"),
                new Animal(66, "Kudu, greater", 15, "Fijian", "Female"),
                new Animal(67, "Pademelon, red-legged", 17, "Ndebele", "Female"),
                new Animal(68, "Desert spiny lizard", 7, "Bulgarian", "Male"),
                new Animal(69, "Carpet snake", 35, "Ndebele", "Polygender"),
                new Animal(70, "South American sea lion", 34, "Arabic", "Bigender"),
                new Animal(71, "Eagle, golden", 44, "German", "Male"),
                new Animal(72, "Kite, black", 27, "Hiri Motu", "Male"),
                new Animal(73, "Turtle, long-necked", 20, "Kurdish", "Female"),
                new Animal(74, "Caiman, spectacled", 35, "Lao", "Female"),
                new Animal(75, "Iguana, common green", 33, "Punjabi", "Male")
        );
    }

    @Test
    void testTask1() {
        List<Animal> expectedAnimals = Arrays.asList(
                new Animal(34, "Red-tailed cockatoo", 19, "Dhivehi", "Female"),
                new Animal(64, "Peregrine falcon", 19, "Estonian", "Female"),
                new Animal(24, "Komodo dragon", 20, "Bislama", "Genderqueer"),
                new Animal(47, "Tamandua, southern", 20, "Ndebele", "Male"),
                new Animal(73, "Turtle, long-necked", 20, "Kurdish", "Female")
        );
        System.out.println(animals);
        List<Animal> result = Main.task1(animals);
        assertEquals(expectedAnimals, result);
    }
}
