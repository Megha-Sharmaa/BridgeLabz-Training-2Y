/**
 * Time and Space Complexity Analysis
 * ===================================
 * This file contains Java implementations along with complexity analysis
 * for Linear Search, Binary Search, and Merge Sort.
 */

public class ComplexityAnalysis {

    // ============================================
    // SECTION 3: TIME COMPLEXITY PROBLEMS
    // ============================================

    /**
     * Problem TC-1: Linear Search Time Complexity
     * ============================================
     * Sample Input Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. BEST CASE: O(1)
     *    Explanation: The best case occurs when the target element is found
     *    at the very first position of the array. For example, searching for
     *    target = 8 in array {8, 61, 2, 3, 4, 0} requires only ONE comparison.
     *    The loop checks index 0, finds 8 immediately, and returns.
     *    Time complexity: O(1) — constant time, independent of array size.
     *
     * 2. WORST CASE: O(n)
     *    Explanation: The worst case occurs when the target element is at the
     *    last position OR not present in the array at all. For example,
     *    searching for target = 0 in array {8, 61, 2, 3, 4, 0} requires checking
     *    ALL 6 elements. If searching for 5 (not present), all 6 elements are
     *    checked before returning "not found".
     *    Time complexity: O(n) — linear time, proportional to array size.
     *
     * 3. AVERAGE CASE: O(n)
     *    Explanation: On average, the target will be found at a random position.
     *    If the target is equally likely to be at any position (or not present),
     *    the expected number of comparisons is approximately n/2.
     *    Since we drop constants in Big-O notation, n/2 → O(n).
     *    Even on average, we may need to scan about half the array.
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Best case: first element → O(1)
            }
        }
        return -1; // Worst case: not found → O(n)
    }


    /**
     * Problem TC-2: Iterative Binary Search Time Complexity
     * ======================================================
     * Sample Sorted Array: {0, 2, 3, 4, 8, 61}
     *
     * 1. STEP-BY-STEP SEARCH for target = 4:
     *
     *    Array:  [0, 2, 3, 4, 8, 61]
     *    Indices: 0  1  2  3  4  5
     *
     *    Step 1: low=0, high=5, mid=(0+5)/2=2, arr[2]=3
     *            3 < 4, so search right half: low=3, high=5
     *
     *    Step 2: low=3, high=5, mid=(3+5)/2=4, arr[4]=8
     *            8 > 4, so search left half: low=3, high=3
     *
     *    Step 3: low=3, high=3, mid=(3+3)/2=3, arr[3]=4
     *            4 == 4 → FOUND!
     *
     *    Total comparisons: 3
     *
     * 2. WORST CASE TIME COMPLEXITY DERIVATION:
     *
     *    At each step, the search space is divided in half:
     *    - Start: n elements
     *    - After 1 comparison: n/2 elements
     *    - After 2 comparisons: n/4 elements
     *    - After k comparisons: n/(2^k) elements
     *
     *    The algorithm stops when n/(2^k) = 1 (one element remains).
     *
     *    Solving for k:
     *        n / (2^k) = 1
     *        2^k = n
     *        k = log₂(n)
     *
     *    Therefore, the worst-case number of comparisons is ⌈log₂(n)⌉.
     *    Time complexity: O(log n)
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;           // Found
            } else if (arr[mid] < target) {
                low = mid + 1;        // Search right half
            } else {
                high = mid - 1;       // Search left half
            }
        }
        return -1; // Not found
    }


    /**
     * Problem TC-3: Merge Sort Time Complexity
     * =========================================
     * Sample Input Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. DIVISION/SPLIT TREE:
     *
     *    Level 0:              [8, 61, 2, 3, 4, 0]
     *                             /            \
     *    Level 1:         [8, 61, 2]        [3, 4, 0]
     *                       /     \          /     \
     *    Level 2:      [8, 61]   [2]    [3, 4]   [0]
     *                    /   \            /   \
     *    Level 3:    [8]   [61]      [3]   [4]
     *
     *    (Each single-element array is the base case)
     *
     * 2. RECURRENCE RELATION (Recursion Tree Method):
     *
     *    The recurrence for Merge Sort is:
     *        T(n) = 2T(n/2) + O(n)
     *
     *    Where:
     *    - 2T(n/2): Two recursive calls on halves of size n/2
     *    - O(n):    Cost of merging two sorted halves
     *
     *    RECURSION TREE ANALYSIS:
     *
     *    Level 0:  1 subproblem of size n        → work = n
     *    Level 1:  2 subproblems of size n/2     → work = 2 × (n/2) = n
     *    Level 2:  4 subproblems of size n/4     → work = 4 × (n/4) = n
     *    Level 3:  8 subproblems of size n/8     → work = 8 × (n/8) = n
     *    ...
     *    Level k:  2^k subproblems of size n/(2^k) → work = 2^k × (n/2^k) = n
     *
     *    The tree has log₂(n) levels (until subproblem size = 1).
     *
     *    Total work = work per level × number of levels
     *               = n × log₂(n)
     *
     *    Time Complexity: O(n log n)
     *
     *    This holds for ALL cases (best, average, worst) because Merge Sort
     *    always divides and always merges regardless of input order.
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide
            mergeSort(arr, left, mid);       // T(n/2)
            mergeSort(arr, mid + 1, right);  // T(n/2)

            // Conquer (Merge)
            merge(arr, left, mid, right);    // O(n)
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }


    // ============================================
    // SECTION 4: SPACE COMPLEXITY PROBLEMS
    // ============================================

    /**
     * Problem SC-1: Linear Search Space Complexity
     * =============================================
     * Sample Input Array: {8, 61, 2, 3, 4, 0}
     *
     * Auxiliary Space Complexity: O(1)
     *
     * Explanation: Iterative Linear Search uses only a constant amount of
     * extra memory regardless of input size. The algorithm only needs:
     *    - One loop index variable (i)
     *    - Possibly a variable to store the target or result
     *
     * No additional arrays, stacks, or recursive calls are made.
     * The input array itself occupies O(n) space, but AUXILIARY space
     * (extra space used by the algorithm) is O(1).
     */


    /**
     * Problem SC-2: Binary Search Space Complexity
     * =============================================
     * Sample Sorted Array: {0, 2, 3, 4, 8, 61}
     *
     * Auxiliary Space Complexity for ITERATIVE Binary Search: O(1)
     *
     * Explanation: The iterative implementation of Binary Search uses only
     * a constant amount of extra memory:
     *    - Variables: low, high, mid
     *    - No recursive calls → no call stack overhead
     *    - No additional data structures
     *
     * Note: A RECURSIVE implementation of Binary Search would use O(log n)
     * auxiliary space due to the function call stack (each recursive call
     * adds a stack frame, and the maximum depth is log₂(n)).
     */


    /**
     * Problem SC-3: Merge Sort Space Complexity
     * ==========================================
     * Sample Input Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. WHY MERGING REQUIRES EXTRA MEMORY:
     *
     *    During the merge step, we need to compare elements from two sorted
     *    subarrays and place them in the correct order. This requires:
     *    - Creating temporary arrays to hold the left and right halves
     *    - These temporary arrays cannot be avoided in the standard implementation
     *
     *    At each merge step, temporary arrays of total size n are allocated.
     *    In a typical implementation, the maximum extra space needed at any
     *    point is proportional to n (the size of the original array).
     *
     *    Auxiliary Space Complexity: O(n)
     *
     * 2. COMPARISON WITH IN-PLACE SORTING ALGORITHMS:
     *
     *    Algorithm         | Auxiliary Space | In-Place?
     *    ------------------|-----------------|----------
     *    Merge Sort        | O(n)            | No
     *    Insertion Sort    | O(1)            | Yes
     *    Quick Sort        | O(log n)*       | Yes (average)
     *    Heap Sort         | O(1)            | Yes
     *
     *    *Quick Sort uses O(log n) space for the recursion stack in average case.
     *
     *    Merge Sort is NOT space-efficient compared to in-place algorithms.
     *    The O(n) extra space is its main drawback. However, it offers:
     *    - Guaranteed O(n log n) time (unlike Quick Sort's worst O(n²))
     *    - Stable sorting (preserves relative order of equal elements)
     *    - Excellent performance for linked lists and external sorting
     *
     *    Trade-off: Merge Sort sacrifices space efficiency for time consistency
     *    and stability. In-place algorithms like Quick Sort or Heap Sort use
     *    less space but may have worse worst-case behavior or lack stability.
     */


    // ============================================
    // MAIN METHOD (for testing)
    // ============================================
    public static void main(String[] args) {
        int[] sampleArray = {8, 61, 2, 3, 4, 0};
        int[] sortedArray = {0, 2, 3, 4, 8, 61};

        // Test Linear Search
        System.out.println("Linear Search for 4: " + linearSearch(sampleArray, 4));
        System.out.println("Linear Search for 5: " + linearSearch(sampleArray, 5));

        // Test Binary Search
        System.out.println("Binary Search for 4: " + binarySearch(sortedArray, 4));
        System.out.println("Binary Search for 5: " + binarySearch(sortedArray, 5));

        // Test Merge Sort
        int[] toSort = {8, 61, 2, 3, 4, 0};
        mergeSort(toSort, 0, toSort.length - 1);
        System.out.print("Merge Sort result: ");
        for (int num : toSort) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
