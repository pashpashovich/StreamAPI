package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private static final int PENSION_AGE_MEN = 63;
    private static final int PENSION_AGE_WOMEN = 58;

    public static void main(String[] args) {
        task1(Util.getAnimals());
        task2(Util.getAnimals());
        task3(Util.getAnimals());
        task4(Util.getAnimals());
        task5(Util.getAnimals());
        task6(Util.getAnimals());
        task7(Util.getAnimals());
        task8(Util.getAnimals());
        task9(Util.getAnimals());
        task10(Util.getAnimals());
        task11(Util.getAnimals());
        task12();
        task13();
        task14();
        task15(Util.getFlowers());
        task16(Util.getStudents());
        task17(Util.getStudents());
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static List<Animal> task1(List<Animal> animals) {
        System.out.println("Task 1");
        List<Animal> myAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .toList();
        for (Animal animal : myAnimals)
            System.out.println(animal);
        return myAnimals;
    }

    public static List<String> task2(List<Animal> animals) {
        System.out.println("Task 2");
        List<String> breedOfAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .map(animal -> {
                    String breed = animal.getBread();
                    if (animal.getGender().equalsIgnoreCase("Female")) breed = breed.toUpperCase();
                    return breed;
                })
                .toList();
        System.out.println("Породы:");
        for (String breed : breedOfAnimals) System.out.println(breed);
        return breedOfAnimals;
    }

    public static List<String> task3(List<Animal> animals) {
        System.out.println("Task 3");
        List<String> countries = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .<String>mapMulti((x, consumer) -> {
                    if (x.getOrigin().startsWith("A")) consumer.accept(x.getOrigin());
                })
                .distinct()
                .toList();
        System.out.println("Страны");
        for (String country : countries)
            System.out.println(country);
        return countries;
    }

    public static long task4(List<Animal> animals) {
        System.out.println("Task 4");
        long females =
                animals.stream()
                        .filter(animal -> animal.getGender().equalsIgnoreCase("Female"))
                        .count();
        System.out.println("Количество животных Female: " + females);
        return females;
    }

    public static boolean task5(List<Animal> animals) {
        System.out.println("Task 5");
        boolean isThereHungarian =
                animals.stream()
                        .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                        .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Hungarian"));
        System.out.println("Есть ли венгерские животные: " + isThereHungarian);
        return isThereHungarian;
    }

    public static boolean task6(List<Animal> animals) {
        System.out.println("Task 6");
        boolean isAllMaleAndFemale =
                animals.stream()
                        .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equalsIgnoreCase("Female"));
        System.out.println("Все male и female? " + isAllMaleAndFemale);
        return isAllMaleAndFemale;
    }

    public static boolean task7(List<Animal> animals) {
        System.out.println("Task 7");
        boolean isNoneFromOceania =
                animals.stream()
                        .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println("Никого из Oceania? " + isNoneFromOceania);
        return isNoneFromOceania;
    }

    public static int task8(List<Animal> animals) {
        System.out.println("Task 8");
        int maxAge =
                animals.stream()
                        .sorted(Comparator.comparing(Animal::getBread))
                        .limit(100)
                        .mapToInt(Animal::getAge)
                        .max()
                        .orElse(0);
        System.out.println("Возраст самого старого животного: " + maxAge);
        return maxAge;
    }

    public static int task9(List<Animal> animals) {
        System.out.println("Task 9");
        int minLengthofBreed =
                animals.stream()
                        .map(Animal::getBread)
                        .map(String::toCharArray)
                        .mapToInt(chars -> chars.length)
                        .min()
                        .orElse(0);
        System.out.println("Самое короткое название породы имеет " + minLengthofBreed + " символов.");
        return minLengthofBreed;
    }

    public static int task10(List<Animal> animals) {
        System.out.println("Task 10");
        int totalAge =
                animals.stream()
                        .mapToInt(Animal::getAge)
                        .sum();
        System.out.println("Cуммарный возраст всех животных " + totalAge);
        return totalAge;
    }

    public static double task11(List<Animal> animals) {
        System.out.println("Task 11");
        double averageAgeFromIndonesia =
                animals.stream()
                        .filter(animal -> animal.getOrigin().equalsIgnoreCase("Indonesian"))
                        .mapToInt(Animal::getAge)
                        .average()
                        .orElse(0);
        System.out.println("Средний возраст животных из Indonesia: " + averageAgeFromIndonesia);
        return averageAgeFromIndonesia;
    }

    public static void task12() {
        System.out.println("Task 12");
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Male"))
                .filter(person -> {
                    int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static void task13() {
        System.out.println("Task 13");
        List<House> houses = Util.getHouses();
        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> new Object[]{person, getPriority(person, house.getBuildingType())}))
                .sorted(Comparator.comparingInt(p -> (int) p[1]))
                .limit(500)
                .map(p -> (Person) p[0])
                .forEach(System.out::println);
    }

    private static int getPriority(Person person, String buildingType) {
        int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
        boolean isChildOrElderly = age < 18 || (person.getGender().equalsIgnoreCase("male") && age >= PENSION_AGE_MEN) || (person.getGender().equalsIgnoreCase("female") && age >= PENSION_AGE_WOMEN);
        if (buildingType.equalsIgnoreCase("Hospital")) {
            return 1;
        } else if (isChildOrElderly) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void task14() {
        System.out.println("Task 14");
        List<Car> cars = Util.getCars();
        double costPerTon = 7.14;
        double[] tierMasses = new double[6];
        cars.stream()
                .forEach(car -> {
                    if (car.getCarMake().equalsIgnoreCase("Jaguar") ||
                            car.getColor().equalsIgnoreCase("White")) {
                        tierMasses[0] += car.getMass();
                    } else if (car.getMass() < 1500 &&
                            (car.getCarMake().equalsIgnoreCase("BMW") || car.getCarMake().equalsIgnoreCase("Lexus") ||
                                    car.getCarMake().equalsIgnoreCase("Chrysler") || car.getCarMake().equalsIgnoreCase("Toyota"))) {
                        tierMasses[1] += car.getMass();
                    } else if ((car.getColor().equalsIgnoreCase("Black") && car.getMass() > 4000) ||
                            car.getCarMake().equalsIgnoreCase("GMC") || car.getCarMake().equalsIgnoreCase("Dodge")) {
                        tierMasses[2] += car.getMass();
                    } else if (car.getReleaseYear() < 1982 ||
                            car.getCarModel().equalsIgnoreCase("Civic") || car.getCarModel().equalsIgnoreCase("Cherokee")) {
                        tierMasses[3] += car.getMass();
                    } else if (!"Yellow".equalsIgnoreCase(car.getColor()) && !"Red".equalsIgnoreCase(car.getColor()) &&
                            !"Green".equalsIgnoreCase(car.getColor()) && !"Blue".equalsIgnoreCase(car.getColor()) ||
                            car.getPrice() > 40000) {
                        tierMasses[4] += car.getMass();
                    } else if (car.getVin().contains("59")) {
                        tierMasses[5] += car.getMass();
                    }
                });
        double firstTierCost = (tierMasses[0] / 1000.0) * costPerTon;
        double secondTierCost = (tierMasses[1] / 1000.0) * costPerTon;
        double thirdTierCost = (tierMasses[2] / 1000.0) * costPerTon;
        double fourthTierCost = (tierMasses[3] / 1000.0) * costPerTon;
        double fifthTierCost = (tierMasses[4] / 1000.0) * costPerTon;
        double sixthTierCost = (tierMasses[5] / 1000.0) * costPerTon;
        System.out.println("1. Туркменистан: $" + firstTierCost);
        System.out.println("2. Узбекистан: $" + secondTierCost);
        System.out.println("3. Казахстан: $" + thirdTierCost);
        System.out.println("4. Кыргызстан: $" + fourthTierCost);
        System.out.println("5. Россия: $" + fifthTierCost);
        System.out.println("6. Монголия: $" + sixthTierCost);
        double totalRevenue = firstTierCost + secondTierCost + thirdTierCost + fourthTierCost + fifthTierCost + sixthTierCost;
        System.out.println("Общая выручка логистической компании: $" + totalRevenue);
    }

    public static double task15(List<Flower> flowers) {
        System.out.println("Task 15");
        double waterCostPerCubicMeter = 1.39;
        double result =
                flowers.stream()
                        .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                                .thenComparing(Flower::getPrice)
                                .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                        .filter(flower -> flower.getCommonName().toUpperCase().compareTo("C") <= 0 ||
                                flower.getCommonName().toUpperCase().compareTo("S") >= 0)
                        .filter(Flower::isShadePreferred)
                        .filter(flower -> flower.getFlowerVaseMaterial().contains("Glass") || flower.getFlowerVaseMaterial().contains("Aluminum") ||
                                flower.getFlowerVaseMaterial().contains("Steel"))
                        .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * (4 * 365 + 366) * waterCostPerCubicMeter)
                        .sum();
        System.out.println("Общая стоимость обслуживания всех растений: " + result + "$");
        return result;
    }

    public static List<Student> task16(List<Student> students) {
        System.out.println("Task 16");
        List<Student> studentsUnder18 =
                students.stream()
                        .filter(student -> student.getAge() < 18)
                        .sorted(Comparator.comparing(Student::getSurname))
                        .toList();
        System.out.println("Студенты младше 18 лет в алфавитном порядке: ");
        if (studentsUnder18.isEmpty()) System.out.println("Таких нет(");
        for (Student student : studentsUnder18)
            System.out.println(student.getSurname() + " " + student.getAge());
        return studentsUnder18;
    }

    public static List<String> task17(List<Student> students) {
        System.out.println("Task 17");
        List<String> groups =
                students.stream()
                        .map(Student::getGroup)
                        .distinct()
                        .toList();
        System.out.println("Список групп");
        for (String group : groups)
            System.out.println(group);
        return groups;
    }

    public static void task18() {
        System.out.println("Task 18");
        List<Student> students = Util.getStudents();
        Map<String, Double> averageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)));
        averageAgeByFaculty.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void task19() {
        System.out.println("Task 19");
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        List<String> groups = Util.getStudents().stream()
                .map(Student::getGroup)
                .distinct().toList();
        String group;
        while (true) {
            System.out.println("Введите номер группы: ");
            Scanner sсanner = new Scanner(System.in);
            try {
                group = sсanner.next();
                if (groups.contains(group)) break;
                else System.out.println("Неверный номер группы... Повторите попытку");
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод... Повторите попытку");

            }
        }
        String finalGroup = group;
        students.stream()
                .filter(student -> student.getGroup().equals(finalGroup))
                .filter(student -> examinations.stream().anyMatch(
                        examination -> examination.getStudentId() == student.getId()
                                && examination.getExam3() > 4))
                .forEach(System.out::println);
    }

    public static void task20() {
        System.out.println("Task 20");
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        System.out.println("Факультет с максимальной средней оценкой по первому экзамену:");
        Map<String, Double> averageExam1ByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(student -> examinations.stream()
                        .filter(exam -> exam.getStudentId() == student.getId())
                        .mapToInt(Examination::getExam1)
                        .average()
                        .orElse(0))));
        averageExam1ByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    public static void task21() {
        System.out.println("Task 21");
        List<Student> students = Util.getStudents();
        students.stream()
                .collect((Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()
                )))
                .forEach((group, num) -> System.out.println("Номер группы: " + group + " " + " количество: " + num + "."));
    }

    public static void task22() {
        System.out.println("Task 22");
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.minBy(Comparator.comparing(Student::getAge))
                ))
                .forEach((faculty, optionalStudent) -> {
                    if (optionalStudent.isPresent()) {
                        System.out.println("Факультет: " + faculty + ", минимальный возраст: " + optionalStudent.get().getAge() + ".");
                    } else {
                        System.out.println("Факультет: " + faculty + ", данных о студентах нет");
                    }
                });
    }
}