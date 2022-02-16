package phonebook;

import java.util.Objects;

public class Entry implements Comparable<Entry> {
    public static int count;
    public final int id;
    final String phoneNumber;
    public final String name;
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
    public int compareTo(Entry o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Entry entry = (Entry) o;
        return name.equals(entry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}