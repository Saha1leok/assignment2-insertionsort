package cli;

import algorithms.InsertionSortOptimized;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 50000};

        System.out.println("--- Running Insertion Sort (Optimized) Benchmarks ---");
        System.out.printf("%-8s | %-12s | %-15s | %-15s | %s\n",
                          "Size N", "Time (ms)", "Comparisons", "Shifts/Swaps", "Array Accesses");
        System.out.println("---------------------------------------------------------------------------------");

        for (int n : sizes) {
            runBenchmark(n);
        }
    }

    private static void runBenchmark(int n) {
        int[] arr = generateRandomArray(n);
        
        InsertionSortOptimized.sort(arr);
        
        System.out.printf("%-8d | %-12d | %-15d | %-15d | %d\n",
                          n, 
                          PerformanceTracker.getExecutionTimeMs(),
                          PerformanceTracker.getComparisons(),
                          PerformanceTracker.getSwaps(),
                          PerformanceTracker.getArrayAccesses());
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }
    
    private static int[] generateNearlySortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        
        Random rand = new Random();
        int swapsCount = (int) (size * 0.05);
        for (int i = 0; i < swapsCount; i++) {
            int idx1 = rand.nextInt(size);
            int idx2 = rand.nextInt(size);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }
}
