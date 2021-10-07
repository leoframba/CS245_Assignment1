/**
 * @author leofr
 */
public class Sort {
    /**
     * Swap two values in an array
     *
     * @param inputArr - inputted Array
     * @param indexOne - first index
     * @param indexTwo - second index
     */
    public void swap(double[] inputArr, int indexOne, int indexTwo) {
        double temp = inputArr[indexOne];
        inputArr[indexOne] = inputArr[indexTwo];
        inputArr[indexTwo] = temp;
    }

    public void sort() {
    }

}
