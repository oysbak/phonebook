package phonebook;

import phonebook.directory.Directory;
import phonebook.directory.DirectoryBubbleJump;
import phonebook.directory.DirectoryHashTable;
import phonebook.directory.DirectoryQuickBinary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            System.out.println("Marty Filide".hashCode() == "Patrizia Benzel".hashCode());
        //List<Person> persons = Person.loadPersons(FilePaths.FIND_PATH);
//        doTheLinearRun(persons);
//        doTheBubbleJumpRun(persons);
//        doTheQuickBinaryRun(persons);
        //doTheHashTableRun(persons);
    }

    private static void doTheHashTableRun(List<Person> persons) {
        System.out.println("Start searching (hash table)...");
        StopWatch totalTimer = new StopWatch(true);
        StopWatch createTimer = new StopWatch(true);
        DirectoryHashTable phoneBook = new DirectoryHashTable(FilePaths.DIRECTORY_PATH);
        String createTime = createTimer.stop(false);
        StopWatch searchTimer = new StopWatch(true);
        int findCount = 0;
        for (Person person : persons) {
            Entry entry = new Entry(null, person.name);
            if (phoneBook.hashTableSearch(entry)) {
                findCount++;
            } else {
                System.out.println("Not to be found...");
                System.out.println(entry);
            }
        }
        String searchTime = searchTimer.stop(false);
        String totalTime = totalTimer.stop(false);
        System.out.print("Found " + findCount + " / " + persons.size() + " entries. ");
        System.out.println("Time taken: " + totalTime);
        System.out.println("Creating time:: " + createTime);
        System.out.println("Searching time: " + searchTime);
        System.out.println();
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
