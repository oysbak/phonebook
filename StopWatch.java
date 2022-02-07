package phonebook;

public class StopWatch {
    private final long start;
    private long end;

    private StopWatch() {
        start = System.currentTimeMillis();
    }

    public static StopWatch start() {
        return new StopWatch();
    }

    void stop() {
        end = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        long durationInMillis = end - start;
        long millis = durationInMillis % 1000;
        long second = (durationInMillis / 1000) % 60;
        long minute = (durationInMillis / (1000 * 60)) % 60;
        return "Time taken: " + minute + " min. " + second + " sec. " + millis + " ms.";
    }
}
