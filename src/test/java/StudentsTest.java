import by.clevertec.Main;
import by.clevertec.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentsTest {

    private static List<Student> students;

    @BeforeEach
    void setUp() {
        students = Arrays.asList(
                new Student(2, "Carter", 19, "ComputerScience", "C-2"),
                new Student(11, "Jonson", 18, "Physics", "P-1"),
                new Student(15, "Williams", 19, "ComputerScience", "C-2"),
                new Student(31, "Brown", 16, "Chemistry", "C-1"),
                new Student(43, "Baker", 17, "Mathematics", "M-1"),
                new Student(49, "Lopez", 18, "Physics", "P-1"),
                new Student(50, "Miller", 19, "ComputerScience", "C-2")
        );
    }

    @Test
    void testTask16() {
        List<Student> expected = Arrays.asList(
                new Student(43, "Baker", 17, "Mathematics", "M-1"),
                new Student(31, "Brown", 16, "Chemistry", "C-1"));
        List<Student> result = Main.task16(students);
        assertEquals(expected, result);
    }

    @Test
    void testTask17() {
        List<String> expected = Arrays.asList("C-2", "P-1", "C-1", "M-1");
        List<String> result = Main.task17(students);
        assertEquals(expected, result);
    }

}
