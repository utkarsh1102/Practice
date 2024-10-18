package DataStructureAndAlgorithm.Sorting;

import java.util.Arrays;

public class Merge_sort {
    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // ye dono array ko check kera ge, ke kohie khaali tho nahi hai
        // ager kohie sa bhi khaali hoga tho ye while loop se baher aa jayega.
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        return combined;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midindex = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midindex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midindex, array.length));
        return merge(left, right);
    }


    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};
        int[] sortedArray = mergeSort(originalArray);

        System.out.println("\nOriginal Array: " + Arrays.toString(originalArray));

        System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));


//        int[] array1 = {1, 3, 7, 8};
//        int[] array2 = {2, 4, 5, 6};
//
//        System.out.println(Arrays.toString(merge(array1, array2)));
    }
}
