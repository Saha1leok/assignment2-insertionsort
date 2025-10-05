# Assignment 2: Linear Array Algorithms
**Course:** Algorithm Analysis & Design  
**Assignment:** Pair 1 – Linear Array Algorithms  
**Student / Team:** Pair 1 – Insertion Sort Implementation

---

## 📋 Project Overview

This project implements the **Insertion Sort** algorithm with a full suite for measuring and analyzing performance, comparing empirical data with theoretical expectations.  
The goal is to understand how a simple quadratic algorithm behaves under various input distributions and to rigorously profile its behavior.

**Key Features:**

- Insertion Sort algorithm (with detailed instrumentation)
- Tracking metrics: execution time, number of comparisons, assignments, array accesses
- Support for various input types: sorted, reverse sorted, random, partially sorted
- Benchmarking across multiple input sizes
- Comprehensive test suite for correctness, edge cases, and performance

---

## 🔬 Algorithm Details

### Insertion Sort

**Problem:** Sort an array (or list) of comparable elements into non-decreasing order.

**Algorithm Steps:**

1. For `i = 1` to `n - 1`:
2. Set `key = A[i]`
3. Compare `key` with elements `A[j]` for `j = i - 1, i - 2, …, 0`
4. While `A[j] > key`, shift `A[j]` one position right (`A[j + 1] = A[j]`)
5. Insert `key` at the position `j + 1`

This is the classic insertion-sort algorithm, but instrumented to count operations.

**Time & Space Complexity:**

| Case              | Time Complexity | Space Complexity |
|-------------------|------------------|-------------------|
| Best (nearly sorted) | Θ(n)            | Θ(1)             |
| Average           | Θ(n²)            | Θ(1)             |
| Worst (reverse sorted) | Θ(n²)        | Θ(1)             |

**Tracked Operations:**

- Number of comparisons
- Number of assignments / shifts
- Array accesses
- (Optional) Memory usage
- You may add optimizations such as minimizing unnecessary assignments

---

## 🏗 Project Structure

Example directory layout:

assignment2-insertionsort/
├── src/
│ ├── main/java/org/example/
│ │ ├── algorithms/
│ │ │ └── InsertionSort.java
│ │ ├── utils/
│ │ │ ├── PerformanceTracker.java
│ │ │ └── BenchmarkRunner.java
│ └── test/java/
│ └── InsertionSortTest.java
├── docs/
│ └── performance-plots/
├── pom.xml
└── README.md

yaml
Копировать код

Adjust according to your actual package names and class names.

---

## 🧪 Testing

**Test Coverage:**

- Functional tests: sorting random arrays
- Edge cases: empty array, single-element, all-equal, already sorted, reverse sorted
- Correctness comparison: compare output with `Arrays.sort(...)` or another trusted sort
- Performance tests: verify that metrics are collected and execution behaves as expected

**Run tests:**

```bash
mvn test
To run a specific test:
```
```bash
mvn test -Dtest=InsertionSortTest
Generate a coverage report with JaCoCo:
```
```bash
mvn test jacoco:report
```
### 📊 Benchmarking & Performance Analysis
Input Distributions:

Already sorted (ascending)

Reverse sorted (descending)

Random

Partially sorted (e.g. a few elements out of place)

Experiment Sizes:

E.g. 100, 1,000, 10,000, 50,000 etc.

Measured Metrics:

Execution time (ms)

Total comparisons

Total assignments / shifts

Array accesses

(Optional) Memory usage

Expected Observations:

Time grows roughly quadratically w.r.t. n (i.e. ~ c·n²)

Input distribution significantly affects actual time: nearly sorted input may approach linear behavior

Reverse or random inputs should clearly reflect quadratic growth

Use the results to generate plots (in docs/performance-plots) and assess how well empirical results align with theoretical predictions.

### 🚀 Build & Run
Prerequisites:

Java 21 or newer

Maven 3.6+

Build the project:

bash
Копировать код
mvn clean compile
Run benchmarks (if you have a main class entry):

bash
Копировать код
mvn exec:java -Dexec.mainClass="org.example.utils.BenchmarkRunner"
Make sure your BenchmarkRunner (or equivalent) includes a main method and supports configuration of experiments.

### 🏅 Expected Growth & Results
n	Behavior Pattern	Theoretical Estimate
100	very fast	~ O(100²) ~ 10,000 small operations
1,000	noticeably slower	~ O(1,000²) ~ 1,000,000 operations
10,000	much slower	~ O(10,000²) ~ 100,000,000 operations

If you scale n by factor 10, time should scale roughly by factor ~100 (quadratic) in non-ideal cases.

### ✅ Known Limitations & Caveats
Timing measurements may be noisy due to JVM warm-up, garbage collection, JIT, etc.

For large n (e.g., > 100,000), performance may become impractically slow

Memory usage tracking is approximate

The overhead of instrumentation can influence measurements