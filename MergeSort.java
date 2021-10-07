/**
 * @author leofr
 * <p>
 * Merge Sort
 */
public class MergeSort extends Sort {
    /**
     * Sort an inputted double array with the Merge Sort Algorithm
     *
     * @param inputArr - Unsorted double array
     */
    public void sort(double[] inputArr) {
        split(inputArr);
    }

    /**
     * Recursively split the imputed array until each subarray contains only one element
     *
     * @param inputArr - Unsorted double array
     */
    private void split(double[] inputArr) {
        //split until each subarray has only one element
        if (inputArr.length > 1) {
            //start with the first half of the array
            double[] firstHalf = new double[inputArr.length / 2];
            System.arraycopy(inputArr, 0, firstHalf, 0, inputArr.length / 2);
            //recursive call until first half is split into subarrays of one element
            split(firstHalf);
            //repeat on the second half
            int secondHalfLength = inputArr.length - inputArr.length / 2;
            double[] secondHalf = new double[secondHalfLength];
            System.arraycopy(inputArr, inputArr.length / 2, secondHalf, 0, secondHalfLength);
            split(secondHalf);
            //once both parts of the array have been reduced to subarrys of one element merge
            // them together
            merge(firstHalf, secondHalf, inputArr);
        }
    }

    /**
     * Merge two arrays into a third sorted array
     *
     * @param firstArr  - the first of two sorted arrays to be merged
     * @param secondArr - the second of two sorted arrays to be merged
     * @param mergeArr  - the resulting merged array
     */
    private void merge(double[] firstArr, double[] secondArr, double[] mergeArr) {
        int mergeIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        //Go through both lists and add the smaller of the two elements to mergeArr
        while (firstIndex < firstArr.length && secondIndex < secondArr.length) {
            if (firstArr[firstIndex] < secondArr[secondIndex]) {
                mergeArr[mergeIndex++] = firstArr[firstIndex++];
            } else mergeArr[mergeIndex++] = secondArr[secondIndex++];
        }
        //add the remaining values of the either leftover array
        while (firstIndex < firstArr.length) {
            mergeArr[mergeIndex++] = firstArr[firstIndex++];
        }

        while (secondIndex < secondArr.length) {
            mergeArr[mergeIndex++] = secondArr[secondIndex++];
        }
    }
}

