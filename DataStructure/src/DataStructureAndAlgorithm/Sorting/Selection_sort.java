package DataStructureAndAlgorithm.Sorting;

import java.util.Arrays;

public class Selection_sort {

    // this is the entire selection sort method.
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }
            if (i != minindex) {
                int temp = array[i];
                array[i] = array[minindex];
                array[minindex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,2,6,5,1,3};

        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

}
