package phonebook;

import phonebook.directory.Directory;
import phonebook.directory.DirectoryBubbleJump;
import phonebook.directory.DirectoryQuickBinary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
        doTheLinearRun(persons);
        doTheBubbleJumpRun(persons);
        doTheQuickBinaryRun(persons);
    }

    private static void doTheQuickBinaryRun(List<Person> persons) {
        System.out.println("Start searching (quick sort + binary search)...");
        DirectoryQuickBinary phoneBook = new DirectoryQuickBinary(FilePaths.DIRECTORY_PATH);
        StopWatch totalTimer = new StopWatch(true);
        StopWatch sortTimer = new StopWatch(true);
        phoneBook.quickSort();
        String sortTime = sortTimer.stop(false);
        StopWatch searchTimer = new StopWatch(true);
        int findCount = 0;
        for (Person person : persons) {
            if (phoneBook.binarySearch(person.name)) {
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

    private static void doTheBubbleJumpRun(List<Person> persons) {
        System.out.println("Start searching (bubble sort + jump search)...");
        StopWatch totalTimer = new StopWatch(true);
        StopWatch sortTimer = new StopWatch(true);
        DirectoryBubbleJump phoneBook = new DirectoryBubbleJump(FilePaths.DIRECTORY_PATH);
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

    private static void doTheLinearRun(List<Person> persons) {
        System.out.println("Start searching (linear search)...");
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
}
