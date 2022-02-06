package phonebook;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
        List<Entry> phonebook = Entry.loadEntries(FilePaths.DIRECTORY_PATH);

        int count = 0;
        System.out.println("Start searching...");
        long startTime = System.currentTimeMillis();
        for (Person person : persons) {
            for (Entry entry : phonebook) {
                if (person.name.equals(entry.name)) {
                    count++;
                }
            }
        }
        long durationInMillis = System.currentTimeMillis() - startTime;
        long millis = durationInMillis % 1000;
        long second = (durationInMillis / 1000) % 60;
        long minute = (durationInMillis / (1000 * 60)) % 60;
        long hour = (durationInMillis / (1000 * 60 * 60)) % 24;
        System.out.print("Found " + count + " / " + persons.size() + " entries. ");
        System.out.println("Time taken: " + minute + " min. " + second + " sec. " + millis + " ms.");
    }
}
