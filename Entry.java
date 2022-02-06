package phonebook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entry {
    public static int count;
    public final int id;
    final String phoneNumber;
    final String name;
    boolean isDataOk = true;

    public Entry(String data) {
        id = ++count;
        String[] something = data.split("\\s");
        phoneNumber = something[0];
        switch (something.length) {
            case 2:
                name = something[1];
                break;
            case 3:
                name = something[1] + " " + something[2];
                break;
            default:
                name = "Default case";
                isDataOk = false;
        }
        //checkData();
    }

    public static List<Entry> loadEntries(String filePath) {
        List<Entry> entries = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                entries.add(new Entry(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("Loaded " + entries.size() + " entries from directory");
        return entries;
    }

    private void checkData() {
        if (!isDataOk) {
            System.out.println(id + " name is default case");
        }
        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            System.out.println(id + " phoneNumber is not a number");
            isDataOk = false;
        }
        if (phoneNumber.startsWith("0")) {
            System.out.println(id + " phoneNumber starts with 0");
            isDataOk = false;
        }
    }

    @Override
    public String toString() {
        return id + "\t" + phoneNumber + "\t" + name;
    }
}
