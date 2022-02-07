package phonebook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    public static int count;
    public final int id;
    public final String name;

    public Person(String data) {
        id = ++count;
        name = data;
    }

    public static List<Person> loadPersons(String filePath) {
        List<Person> persons = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                persons.add(new Person(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return persons;
    }

    @Override
    public String toString() {
        return id + "\t" + name;
    }
}
