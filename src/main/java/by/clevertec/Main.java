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
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    private static final int PENSION_AGE_MEN = 63;
    private static final int PENSION_AGE_WOMEN = 58;

    public static void main(String[] args) {
//        task1(Util.getAnimals());
//        task2(Util.getAnimals());
//        task3();
//          task4();
//        task5();
//        task6();
//        task7();
//        task8();
//          task9();
        task10();
//        task11();
//        task12();
//        task13();
//        task14();
//        task15();
//        task16();
//        task17();
//        task18();
//        task19();
//        task20();
//        task21();
//        task22();
    }

    public static List<Animal> task1(List<Animal> animals) {
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
        List<String> breedOfAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .map(animal -> {
                    String breed = animal.getBread();
                    if (animal.getGender().equalsIgnoreCase("Female")) breed = breed.toUpperCase();
                    return breed;
                })
                .toList();
        for (String breed : breedOfAnimals) System.out.println(breed);
        return breedOfAnimals;
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .mapMulti((x, consumer) -> {
                    if (x.getOrigin().startsWith("A")) consumer.accept(x.getOrigin());
                })
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getGender().equalsIgnoreCase("Female"))
                .count());
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Hungarian")));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female")));
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania")));
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElse(0));
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(chars -> chars.length)
                .min()
                .orElse(0));
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream().filter(animal -> animal.getOrigin().equalsIgnoreCase("Indonesian")).mapToInt(Animal::getAge).average().orElse(0));
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream().filter(person -> person.getGender().equalsIgnoreCase("Male")).filter(person -> {
            int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            return age >= 18 && age <= 27;
        }).sorted(Comparator.comparing(Person::getRecruitmentGroup).reversed()).limit(200).forEach(System.out::println);
    }

    public static void task13() {
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
        List<Car> cars = Util.getCars();
        double costPerTon = 7.14;
        List<Car> firstTier = cars.stream()
                .filter(car -> car.getCarMake().equalsIgnoreCase("Jaguar") || car.getColor().equalsIgnoreCase("white"))
                .toList();
        List<Car> remainingCars = cars.stream()
                .filter(car -> !firstTier.contains(car))
                .collect(Collectors.toList());
        List<Car> secondTier = remainingCars.stream()
                .filter(car -> car.getMass() < 1500 &&
                        (car.getCarMake().equalsIgnoreCase("BMW") || car.getCarMake().equalsIgnoreCase("Lexus") ||
                                car.getCarMake().equalsIgnoreCase("Chrysler")) || car.getCarMake().equalsIgnoreCase("Toyota "))
                .toList();
        remainingCars.removeAll(secondTier);

        List<Car> thirdTier = remainingCars.stream()
                .filter(car -> (car.getColor().equalsIgnoreCase("black") && car.getMass() > 4000) ||
                        car.getCarMake().equalsIgnoreCase("GMC") || car.getCarMake().equalsIgnoreCase("Dodge "))
                .toList();
        remainingCars.removeAll(thirdTier);
        List<Car> fourthTier = remainingCars.stream()
                .filter(car -> car.getReleaseYear() < 1982 || car.getCarModel().equalsIgnoreCase("Civic") || car.getCarModel().equalsIgnoreCase("Cherokee"))
                .toList();
        remainingCars.removeAll(fourthTier);
        List<Car> fifthTier = remainingCars.stream()
                .filter(car -> (!"Yellow".equals(car.getColor()) && !"Red".equals(car.getColor()) &&
                        !"Green".equals(car.getColor()) && !"Blue".equals(car.getColor())) ||
                        car.getPrice() > 40000)
                .toList();
        remainingCars.removeAll(fifthTier);
        List<Car> sixthTier = remainingCars.stream()
                .filter(car -> car.getVin().contains("59"))
                .toList();
        double firstTierMass = firstTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double secondTierMass = secondTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double thirdTierMass = thirdTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double fourthTierMass = fourthTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double fifthTierMass = fifthTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double sixthTierMass = sixthTier.stream().mapToDouble(Car::getMass).sum() / 1000.0;
        double firstTierCost = firstTierMass * costPerTon;
        double secondTierCost = secondTierMass * costPerTon;
        double thirdTierCost = thirdTierMass * costPerTon;
        double fourthTierCost = fourthTierMass * costPerTon;
        double fifthTierCost = fifthTierMass * costPerTon;
        double sixthTierCost = sixthTierMass * costPerTon;
        System.out.println("1. Туркменистан: $" + firstTierCost);
        System.out.println("2. Узбекистан: $" + secondTierCost);
        System.out.println("3. Казахстан: $" + thirdTierCost);
        System.out.println("4. Кыргызстан: $" + fourthTierCost);
        System.out.println("5. Россия: $" + fifthTierCost);
        System.out.println("6. Монголия: $" + sixthTierCost);
        double totalRevenue = firstTierCost + secondTierCost + thirdTierCost + fourthTierCost + fifthTierCost + sixthTierCost;
        System.out.println("Общая выручка логистической компании: $" + totalRevenue);
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        System.out.println(flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice).reversed()
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().startsWith("S") &&
                        flower.getCommonName().endsWith("C"))
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().contains("Glass") || flower.getFlowerVaseMaterial().contains("Aluminum") ||
                        flower.getFlowerVaseMaterial().contains("Steel"))
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * (5 * 365) * 0.8)
                .sum());
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream().filter(student -> student.getAge() <= 18) // младше 18 лет студентов нет
                .sorted(Comparator.comparing(Student::getSurname)).forEach(student -> System.out.println(student.getSurname() + " " + student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream().map(Student::getGroup).distinct().forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> averageAgeByFaculty = students.stream().collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)));
        averageAgeByFaculty.entrySet().stream().sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue())).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<Integer, Student> studentsInGroupC3 = students.stream().filter(student -> student.getGroup().equals("C-3")).collect(Collectors.toMap(Student::getId, student -> student));
        Set<Integer> passedExam3StudentIds = examinations.stream().filter(exam -> studentsInGroupC3.containsKey(exam.getStudentId()) && exam.getExam3() > 4).map(Examination::getStudentId).collect(Collectors.toSet());
        studentsInGroupC3.values().stream().filter(student -> passedExam3StudentIds.contains(student.getId())).forEach(System.out::println);
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, Double> averageExam1ByFaculty = students.stream().collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(student -> {
            return examinations.stream().filter(exam -> exam.getStudentId() == student.getId()).mapToInt(Examination::getExam1).average().orElse(0);
        })));
        averageExam1ByFaculty.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect((Collectors.groupingBy(Student::getGroup, Collectors.counting())))
                .forEach((group, num) -> System.out.println("Номер группы: " + group + " " + " количество: " + num + "."));
    }

    public static void task22() {
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
                        System.out.println("Факультет: " + faculty + ", данных о студентах нет.");
                    }
                });
    }
}
