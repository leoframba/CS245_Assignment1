/**
 * @author leofr
 * <p>
 * Insertion Sort
 **/
public class InsertionSort extends Sort {
    /**
     * Sort an inputted array using the Insertion Sort Algorithm
     *
     * @param inputArr - Unsorted double Array
     */
    public void sort(double[] inputArr) {
        for (int i = 1; i < inputArr.length; i++) {
            //current value to insert
            double current = inputArr[i];
            int index;
            //find location to insert current
            for (index = i - 1; index >= 0 && inputArr[index] > current; index--) {
                inputArr[index + 1] = inputArr[index];
            }
            //add next value to insert
            inputArr[index + 1] = current;
        }
    }
}
