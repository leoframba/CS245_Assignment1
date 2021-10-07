/**
 * @author leofr
 * <p>
 * Quick Sort
 */
public class QuickSort extends Sort {
    /**
     * Sort an inputted double array using the Quick Sort Algorithm
     *
     * @param inputArr - unsorted double array
     */
    public void sort(double[] inputArr) {
        quickSort(inputArr, 0, inputArr.length - 1);
    }

    /**
     * Helper method for sort
     *
     * @param inputArr - unsorted double array
     * @param first    - first index
     * @param last     - last index
     */
    private void quickSort(double[] inputArr, int first, int last) {
        //go until the indexes cross over
        if (last > first) {
            //find the partition
            int pivotIndex = partition(inputArr, first, last);
            //recursive call/split array via pivot
            quickSort(inputArr, first, pivotIndex - 1);
            quickSort(inputArr, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array[first...last]
     *
     * @param inputArr - unsorted array
     * @param first    - first index
     * @param last     - last index
     * @return - the pivot
     */
    private int partition(double[] inputArr, int first, int last) {
        double pivot = inputArr[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search + 1 because the first element is the pivot
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && inputArr[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && inputArr[high] > pivot)
                high--;

            // Swap two elements in the list when indexes cross
            if (high > low) {
                //swap
                swap(inputArr, high, low);
            }
        }

        while (high > first && inputArr[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > inputArr[high]) {
            inputArr[first] = inputArr[high];
            //place pivot
            inputArr[high] = pivot;
            //pivot’s new index
            return high;
        } else {
            //pivot’s original index
            return first;
        }
    }
}