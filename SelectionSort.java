/**
 * @author leofr
 * <p>
 * Selection Sort
 */
public class SelectionSort extends Sort {
    /**
     * Sorts an inputted array using the Selection Sort Algorithm
     *
     * @param inputArr - Unsorted double Array
     */
    public void sort(double[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            //find the smallest value in the array
            int minIndex = i;
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[minIndex] > inputArr[j]) minIndex = j;
            }
            //swap the smallest value to the front of the array
            if (minIndex != i) swap(inputArr, i, minIndex);
        }
    }
}
