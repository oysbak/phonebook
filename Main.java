package phonebook;

import phonebook.directory.Directory;
import phonebook.directory.DirectoryBubbleJump;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        doTheLinearRun();
        doTheBubbleJumpRun();
    }

    private static void doTheLinearRun() {
        System.out.println("Start searching (linear search)...");
        List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
        Directory phoneBook = new Directory(FilePaths.DIRECTORY_PATH);
        //System.out.println("Loaded " + phoneBook.getCount() + " entries.");
        StopWatch linearTimer = new StopWatch(true);
        int findCount = 0;
        for (Person person : persons) {
            if (phoneBook.search(person.name)) {
                findCount++;
            }
        }
        System.out.print("Found " + findCount + " / " + persons.size() + " entries. ");
        System.out.println("Time taken: " + linearTimer.stop(false));
        System.out.println();
    }

    private static void doTheBubbleJumpRun() {
        System.out.println("Start searching (bubble sort + jump search)...");
        List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
        StopWatch totalTimer = new StopWatch(true);
        StopWatch sortTimer = new StopWatch(true);
        DirectoryBubbleJump phoneBook = new DirectoryBubbleJump(FilePaths.DIRECTORY_PATH);
        //phoneBook.checkSortedData();
        String sortTime = sortTimer.stop(false);
        StopWatch searchTimer = new StopWatch(true);
        int findCount = 0;
        for (Person person : persons) {
            if (phoneBook.jumpSearch(person.name)) {
                findCount++;
            }
        }
        String searchTime = searchTimer.stop(false);
        String totalTime = totalTimer.stop(false);
        System.out.print("Found " + findCount + " / " + persons.size() + " entries. ");
        System.out.println("Time taken: " + totalTime);
        System.out.println("Sorting time: " + sortTime);
        System.out.println("Searching time: " + searchTime);
        System.out.println();
    }
}
