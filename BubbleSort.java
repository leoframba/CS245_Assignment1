/**
 * @author leofr
 * <p>
 * Bubble Sort
 */
public class BubbleSort extends Sort {
    /**
     * Sort an inputted array using the Bubble Sort Algorithm
     *
     * @param inputArr - Unsorted double Array
     */
    public void sort(double[] inputArr) {
        //flag to check if the array is already sorted
        boolean sortComplete = false;
        //number of indices at the end of the array that have already been sorted
        int sortedIndex = 0;
        while (!sortComplete) {
            sortComplete = true;
            sortedIndex++;
            for (int i = 0; i < inputArr.length - sortedIndex; i++) {
                if (inputArr[i] > inputArr[i + 1]) {
                    swap(inputArr, i, i + 1);
                    sortComplete = false; //if a swap is preformed the array is not sorted
                }
            }
        }
    }
}
