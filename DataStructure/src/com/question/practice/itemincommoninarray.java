package com.question.practice;

import DataStructureAndAlgorithm.HashTables.HashTables;

import java.util.HashMap;

public class itemincommoninarray {

    public static boolean itemInCommon(int[] array1, int[] array2)
    {
        HashMap<Integer, Boolean> myHashmap = new HashMap<>();

        for(int i : array1)
        {
            myHashmap.put(i, true);
        }

        for(int j : array2)
        {
            if(myHashmap.get(j) != null)
            {
                return true;
            }
        }
        return false;
    }
//     public static boolean itemInCommon(int[] array1 , int[] arrays2)
//     {
//         for(int i : array1)
//         {
//             for(int j : arrays2)
//             {
//                 if(i==j)
//                 {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//
    public static void main(String[] args) {
         int[] array1 = {1,3,5};
         int[] array2 = {2,4,5};

        System.out.println(itemInCommon(array1,array2));


    }
}
