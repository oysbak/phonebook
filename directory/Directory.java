package phonebook.directory;

import phonebook.Entry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Directory {
    List<Entry> entries;

    protected Directory() {
    }

    public Directory(String filePath) {
        entries = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            entries.add(new Entry(scanner.nextLine()));
            while (scanner.hasNext()) {
                addEntry(new Entry(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addEntry(Entry entry) {
        entries.add(entry);
    }

    public boolean search(String name) {
        for (Entry entry : entries) {
            if (entry.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void checkSortedData() {
        for (int i = 1; i < entries.size(); i++) {
            if (entries.get(i - 1).compareTo(entries.get(i)) >= 0) {
                System.out.print(entries.get(i - 1));
                System.out.print(" - ");
                System.out.print(entries.get(i));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : entries) {
            sb.append(entry.name).append("\n");
        }
        return sb.toString();
    }
}
