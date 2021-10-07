import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leofr
 * <p>
 * Merge Sort using sorted regions instead
 */

public class RegionMerge extends Sort {
    /**
     * Sort an inputted array using the RegionSort Algorithm
     *
     * @param inputArr - unsorted double array
     */
    public void sort(double[] inputArr) {
        splitRegions(inputArr);
    }

    /**
     * Split the unsorted array into sorted regions
     *
     * @param inputArr- unsorted array
     */
    public void splitRegions(double[] inputArr) {
        ArrayList<double[]> sortedRegions = new ArrayList<>();
        //start of sorted region
        int start = 0;

        for (int i = 0; i < inputArr.length - 1; i++) {
            //look for ends of sorted regions
            if (inputArr[i] > inputArr[i + 1]) {
                sortedRegions.add(Arrays.copyOfRange(inputArr, start, i + 1));
                //update the start when you find an end
                start = i + 1;
            }
        }
        //add the remaining values as final region
        sortedRegions.add(Arrays.copyOfRange(inputArr, start, inputArr.length));

        //sort the regions and store in a temp array to copy back into original array
        double[] temp = sortRegions(sortedRegions);
        System.arraycopy(temp, 0, inputArr, 0, temp.length);
    }

    /**
     * Sort the sorted regions
     *
     * @param sortedRegions - List of sorted regions/arrays
     * @return - sorted array
     */
    private double[] sortRegions(ArrayList<double[]> sortedRegions) {
        //while there's more than one region
        while (sortedRegions.size() > 1) {
            //merge teo regions and return them to the list
            sortedRegions.add(mergeRegions(sortedRegions.remove(0), sortedRegions.remove(0)));
        }
        //return the final merged region
        return sortedRegions.get(0);
    }

    /**
     * Merge two arrays and return the result - same as merge sort
     *
     * @param firstArr  - first of two sorted arrays to be merged
     * @param secondArr - second of two sorted arrays to be merged
     * @return - sorted merged array
     */
    private double[] mergeRegions(double[] firstArr, double[] secondArr) {
        int mergeArraySize = firstArr.length + secondArr.length;
        double[] mergedArray = new double[mergeArraySize];

        int firstIndex = 0;
        int secondIndex = 0;
        int mergeArrayIndex = 0;

        while (firstIndex < firstArr.length && secondIndex < secondArr.length) {
            if (firstArr[firstIndex] < secondArr[secondIndex]) {
                mergedArray[mergeArrayIndex++] = firstArr[firstIndex++];
            } else mergedArray[mergeArrayIndex++] = secondArr[secondIndex++];
        }

        while (firstIndex < firstArr.length)
            mergedArray[mergeArrayIndex++] = firstArr[firstIndex++];

        while (secondIndex < secondArr.length)
            mergedArray[mergeArrayIndex++] = secondArr[secondIndex++];

        return mergedArray;
    }
}

