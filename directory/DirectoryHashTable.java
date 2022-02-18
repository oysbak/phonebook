package phonebook.directory;

import phonebook.Entry;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class DirectoryHashTable extends Directory {
    private Hashtable<Integer, Entry> entries;

    public DirectoryHashTable(String filePath) {
        entries = new Hashtable<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                Entry entry = new Entry(scanner.nextLine());
                int hashCode = entry.hashCode();
                entries.put(hashCode, entry);
                if (entry.hashCode() == -428846915) {
                    System.out.println(entry);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception e = " + e.getMessage());
        }
    }

    public boolean hashTableSearch(Entry entry) {
        return entries.containsKey(entry.hashCode());
    }
}
