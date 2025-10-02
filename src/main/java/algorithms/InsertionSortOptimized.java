package algorithms;

import metrics.PerformanceTracker;

public class InsertionSortOptimized {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        PerformanceTracker.reset();
        PerformanceTracker.startTimer();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            PerformanceTracker.incrementArrayAccesses(1);

            int insertionIndex = binarySearch(arr, key, 0, i - 1);

            int j = i - 1;

            while (j >= insertionIndex) {
                arr[j + 1] = arr[j];
                PerformanceTracker.incrementArrayAccesses(2);
                PerformanceTracker.incrementSwaps();

                j--;
            }

            arr[j + 1] = key;
            PerformanceTracker.incrementArrayAccesses(1);
        }

        PerformanceTracker.stopTimer();
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            PerformanceTracker.incrementComparisons();
            
            int mid = low + (high - low) / 2;
            PerformanceTracker.incrementArrayAccesses(1);
            
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
