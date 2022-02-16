package phonebook.directory;

import phonebook.Entry;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DirectoryBubbleJump extends Directory {

    public DirectoryBubbleJump(String filePath) {
        super();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            entries.add(new Entry(scanner.nextLine()));
            while (scanner.hasNext()) {
                addEntrySorted(new Entry(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getIndex(List<Entry> arrayToSearch, Entry element) {
        int blockSize = (int) Math.floor(Math.sqrt(arrayToSearch.size()));

        int currentLastIndex = blockSize - 1;

        // Jump to next block as long as target element is > currentLastIndex
        // and the array end has not been reached
        while (currentLastIndex < arrayToSearch.size() && element.compareTo(arrayToSearch.get(currentLastIndex)) > 0) {
            currentLastIndex += blockSize;
        }

        // Find accurate position of target element using Linear Search
        for (int currentSearchIndex = currentLastIndex - blockSize + 1;
             currentSearchIndex <= currentLastIndex && currentSearchIndex < arrayToSearch.size();
             currentSearchIndex++) {
            if (element.compareTo(arrayToSearch.get(currentSearchIndex)) <= 0) {
                return currentSearchIndex;
            }
        }
        // Target element not found. Return negative integer as element position.
        return arrayToSearch.size();
    }

    private void addEntrySorted(Entry entry) {
        int index = getIndex(this.entries, entry);
        entries.add(index, entry);
    }

    public boolean jumpSearch(String element) {
        int blockSize = (int) Math.floor(Math.sqrt(entries.size()));

        int currentLastIndex = blockSize - 1;

        // Jump to next block as long as target element is > currentLastIndex
        // and the array end has not been reached
        while (currentLastIndex < entries.size() && element.compareTo(entries.get(currentLastIndex).name) > 0) {
            currentLastIndex += blockSize;
        }

        // Find accurate position of target element using Linear Search
        for (int currentSearchIndex = currentLastIndex - blockSize + 1;
             currentSearchIndex <= currentLastIndex && currentSearchIndex < entries.size();
             currentSearchIndex++) {
            if (element.equals(entries.get(currentSearchIndex).name)) {
                return true;
            }
        }
        // Target element not found. Return negative integer as element position.
        return false;
    }

    private void swap(int i, int j) {
        try {
            Entry temp = entries.get(i);
            entries.set(i, entries.get(j));
            entries.set(j, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    void bubbleSort() {
        for (int length = entries.size(); length > 0; length--) {
            for (int i = 1; i < length; i++) {
                if (entries.get(i - 1).compareTo(entries.get(i)) > 0) {
                    swap(i - 1, i);
                }
            }
        }
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
}
