import java.util.*;

/**
 * @author Leonardo Framba
 * <p>
 * Assignemt 1 is a class that tests the time complexity of 5 Java sorting algorithems(Selction,
 * Bubble, Insertin, Merge, and Quick) and one additional modified form of merge sort I named
 * "RegionMerge". Algoritmes are tested with random doubles and 10 arrays of size 50,000 to 500,
 * 000. Algorithems are timed in milaseconds. The sorting is confimred with a "checkSort" method
 * that terminated the program if a algorithem fails to sort a data set correctly.
 */
public class Assignment1 {
    public static void main(String[] args) {
        Assignment1 ass = new Assignment1();

        //testLists- contains the 10 arrays to be used as data sets for the sorting algorithms
        List<double[]> testLists = ass.generateDoubleArrays();

        //timeLists- contains the recorded time for each sort. Lists are separated by data set
        // size and each internal list contains the time each algorithm took to solve that data set
        ArrayList<ArrayList<Double>> timeLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) { //for loop to initialize the arrays in the time list
            timeLists.add(new ArrayList<>());
        }

        //Algorithms sort all 10 sets before moving to the next algorithm
        SelectionSort ss = new SelectionSort();
        System.out.println("Selection Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            //A temp array "toSort" is used to avoid altering the data sets. This way all
            // algorithms are sorting identical data sets
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            double startTime = System.currentTimeMillis(); //start time
            ss.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime; //emd time
            ass.checkSort(toSort); //Confirm the algorithm correctly sorted the data set
            timeLists.get(i).add(endTime); //add the recorded time to timeList
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }

        BubbleSort bs = new BubbleSort();
        System.out.println("Bubble Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            double startTime = System.currentTimeMillis();
            bs.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime;
            ass.checkSort(toSort);
            timeLists.get(i).add(endTime);
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }

        InsertionSort is = new InsertionSort();
        System.out.println("Insertion Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            double startTime = System.currentTimeMillis();
            is.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime;
            ass.checkSort(toSort);
            timeLists.get(i).add(endTime);
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }

        MergeSort ms = new MergeSort();
        System.out.println("Merge Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            double startTime = System.currentTimeMillis();
            ms.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime;
            ass.checkSort(toSort);
            timeLists.get(i).add(endTime);
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }

        QuickSort qs = new QuickSort();
        System.out.println("Quick Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            double startTime = System.currentTimeMillis();
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            qs.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime;
            timeLists.get(i).add(endTime);
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }

        RegionMerge mms = new RegionMerge();
        System.out.println("MMMerge Sort");
        for (int i = 0; i < testLists.size(); i++) {
            int arrLength = testLists.get(i).length;
            double[] toSort = Arrays.copyOf(testLists.get(i), arrLength);
            double startTime = System.currentTimeMillis();
            mms.sort(toSort);
            double endTime = System.currentTimeMillis() - startTime;
            timeLists.get(i).add(endTime);
            System.out.println(arrLength + " - " + endTime + " - " + ass.checkSort(toSort));
        }
    }

    /**
     * Generate 10 double arrays of sizes 50,000 - 500,000 in increments of 50,000
     *
     * @return A list of double arrays containing random double values to be sorted
     */
    public List<double[]> generateDoubleArrays() {
        ArrayList<double[]> testLists = new ArrayList<>();
        for (int i = 50000; i <= 500000; ) {
            testLists.add(fillRandomDoubleArray(i));
            i += 50000;
        }
        return testLists;
    }

    /**
     * Fills the 10 arrays with random doubles
     *
     * @param arrLength - length of array is used to determine how many doubles to generate
     * @return an array full of random doubles
     */
    public double[] fillRandomDoubleArray(int arrLength) {
        double[] arr = new double[arrLength];
        Random r = new Random();
        for (int i = 0; i < arrLength; i++) {
            arr[i] = r.nextDouble();
        }
        return arr;
    }

    /**
     * Checks an array to see if it's sorted in ascending order. Returns true if it is sorted and
     * terminates the program otherwise
     *
     * @param inputArr - sorted array
     * @return - true if the array is sorted
     */
    boolean checkSort(double[] inputArr) {
        for (int i = 0; i < inputArr.length - 1; i++) {
            if (inputArr[i] > inputArr[i + 1]) {
                System.out.println("Sort Algorithm Failed");
                System.exit(0);
            }
        }
        return true;
    }
}
