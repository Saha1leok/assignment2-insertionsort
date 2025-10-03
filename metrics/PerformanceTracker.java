package metrics;

public class PerformanceTracker {
    private static long comparisons = 0;
    private static long swaps = 0;
    private static long arrayAccesses = 0;
    private static long startTime = 0;
    private static long endTime = 0;

    public static void startTimer() {
        startTime = System.nanoTime();
    }

    public static void stopTimer() {
        endTime = System.nanoTime();
    }

    public static long getExecutionTimeMs() {
        if (endTime == 0) return 0;
        return (endTime - startTime) / 1_000_000;
    }

    public static void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }

    public static void incrementComparisons() {
        comparisons++;
    }

    public static void incrementSwaps() {
        swaps++;
    }

    public static void incrementArrayAccesses(int count) {
        arrayAccesses += count;
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static long getSwaps() {
        return swaps;
    }

    public static long getArrayAccesses() {
        return arrayAccesses;
    }
}
