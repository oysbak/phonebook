package phonebook;

public class StopWatch {
    private long startMark;
    private long endMark;

    StopWatch(boolean doStart) {
        if (doStart) {
            start();
        }
    }

    void start() {
        startMark = System.currentTimeMillis();
    }

    String stop(boolean doPrint) {
        endMark = System.currentTimeMillis();
        if(doPrint){
            System.out.println(this);
        }
        return this.toString();
    }

    @Override
    public String toString() {
        long durationInMillis = endMark - startMark;
        long millis = durationInMillis % 1000;
        long second = (durationInMillis / 1000) % 60;
        long minute = (durationInMillis / (1000 * 60)) % 60;
        return minute + " min. " + second + " sec. " + millis + " ms.";
    }
}
