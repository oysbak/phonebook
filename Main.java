package phonebook;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
        List<Entry> phonebook = Entry.loadEntries(FilePaths.DIRECTORY_PATH);

        int count = 0;
        System.out.println("Start searching...");
        StopWatch stopWatch = StopWatch.start();
        for (Person person : persons) {
            for (Entry entry : phonebook) {
                if (person.name.equals(entry.name)) {
                    count++;
                }
            }
        }
        stopWatch.stop();
        System.out.print("Found " + count + " / " + persons.size() + " entries. ");
        System.out.println(stopWatch);
    }
}
