package phonebook.directory;

import phonebook.Entry;

import java.util.List;

public class DirectoryQuickBinary extends Directory {
    public DirectoryQuickBinary(String filePath) {
        super(filePath);
    }

    private static int binarySearch(String name, List<Entry> entries, int from, int to) {
        if (to - from == 1) {
            return entries.get(from).name.equals(name) ? from : -1;
        }
        int middle = from + (to - from) / 2;
        if (name.compareTo(entries.get(middle).name) >= 0) {
            return binarySearch(name, entries, middle, to);
        } else {
            return binarySearch(name, entries, from, middle);
        }
    }

    private static void quickSort(List<Entry> entries, int from, int to) {
        int length = to - from + 1;
        if (length < 2) {
            return;
        }
        int pivotIndex = ((length - 1) / 2) + from;
        Entry pivot = entries.get(pivotIndex);
        // Partition
        Entry toBeMoved;
        for (int i = from; i <= to; i++) {
            if (i < pivotIndex && entries.get(i).compareTo(pivot) > 0) {
                toBeMoved = entries.get(i);
                entries.set(i, entries.get(pivotIndex - 1));
                entries.set(pivotIndex - 1, entries.get(pivotIndex));
                entries.set(pivotIndex, toBeMoved);
                pivotIndex--;
                i--;
            }
            if (i > pivotIndex && entries.get(i).compareTo(pivot) < 0) {
                toBeMoved = entries.get(i);
                entries.set(i, entries.get(pivotIndex + 1));
                entries.set(pivotIndex + 1, entries.get(pivotIndex));
                entries.set(pivotIndex, toBeMoved);
                pivotIndex++;
                i--;
            }
        }
        int leftTo = pivotIndex - 1;
        int rightFrom = pivotIndex + 1;
        quickSort(entries, from, leftTo);
        quickSort(entries, rightFrom, to);
    }

    public void quickSort() {
        quickSort(this.entries, 0, entries.size() - 1);
    }

    public boolean binarySearch(String name) {
        return binarySearch(name, this.entries, 0, entries.size()) != -1;
    }
}
