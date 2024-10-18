package DataStructureAndAlgorithm.Sorting;

import java.util.Arrays;

public class Quick_sort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    // iss se he humare array jo hai vo sort ho jayega.
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {

            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);

            }
        }
        // iss se 4 swap ho jayega 2 se
    swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void quickSort(int[] array, int left, int right)
    {
        if(left < right)
        {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex-1);
            quickSort(array, pivotIndex+1, right);
        }

    }

    public static void main(String[] args) {
        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray, 0 , 6);
        System.out.println(Arrays.toString(myArray));

//        int returnIndex = pivot(myArray, 0, 6);
//
//        System.out.println("Returned Index: " + returnIndex);
//
//        System.out.println(Arrays.toString(myArray));

    }
}
