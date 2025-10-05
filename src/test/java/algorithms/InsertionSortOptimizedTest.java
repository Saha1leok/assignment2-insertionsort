package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortOptimizedTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        InsertionSortOptimized.sort(arr);
        assertEquals(0, arr.length, "Array should remain empty.");
        assertEquals(0, PerformanceTracker.getComparisons(), "There should be no comparisons in an empty array.");
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        InsertionSortOptimized.sort(arr);
        assertArrayEquals(new int[]{5}, arr, "An array with one element should remain unchanged.");
        assertEquals(0, PerformanceTracker.getComparisons(), "There should be no comparisons in a single-element array.");
    }

    @Test
    void testSortedArrayBestCase() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSortOptimized.sort(arr);
        assertArrayEquals(expected, arr, "A sorted array should remain sorted.");

        assertTrue(PerformanceTracker.getComparisons() > 0, "There should be comparisons (due to binary search optimization).");
        assertEquals(0, PerformanceTracker.getSwaps(), "There should be no shifts/swaps.");
    }

    @Test
    void testReverseSortedArrayWorstCase() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSortOptimized.sort(arr);
        assertArrayEquals(expected, arr, "A reverse-sorted array should be sorted.");

        assertTrue(PerformanceTracker.getSwaps() > 0, "There should be many shifts/swaps.");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {4, 2, 4, 1, 3, 1, 5};
        int[] expected = {1, 1, 2, 3, 4, 4, 5};
        InsertionSortOptimized.sort(arr);
        assertArrayEquals(expected, arr, "An array with duplicates should be sorted correctly.");
    }

    @Test
    void testLargeRandomArray() {
        int size = 1000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }

        int[] copy = arr.clone();
        Arrays.sort(copy);

        InsertionSortOptimized.sort(arr);
        assertArrayEquals(copy, arr, "A large random array should be sorted correctly.");
        
        assertTrue(PerformanceTracker.getExecutionTimeMs() > 0, "Execution time should be greater than 0.");
        assertTrue(PerformanceTracker.getComparisons() > 0, "Comparisons should have been recorded.");
    }
}
