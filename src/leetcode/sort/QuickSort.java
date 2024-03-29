package leetcode.sort;

/**
 * @author chenchris on 2019/4/28.
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] temp = {1, 3, 2, 5, 4, 8, 7, 6};
//        int[] temp1 = {6, 7, 8, 5, 5, 4, 1, 2, 3};
//        int[] temp2 = {5, 1, 1, 2, 0, 0};
//        quickSort(temp2, 0, temp2.length - 1);
//        for (int element : temp2) {
//            System.out.println(element);
//        }
        String s = "1,2,3,4,,,,";
        String[] temp = s.split(",");
        System.out.println(temp);
        for (String r : temp) {
            System.out.println(r);
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        //index
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int smallerIndex = low; // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                // swap array[i] and array[j]
                swap(array, smallerIndex, j);
                smallerIndex++;
            }
        }

        // swap array[smallerIndex] and array[high] (or pivot)
        swap(array, smallerIndex, high);

        return smallerIndex;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
