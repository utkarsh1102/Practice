package com.question.practice;

public class Factorial {

    public static int factorial(int n)

    {
        if(n==1) return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int myFac = factorial(10);
        System.out.println(factorial(myFac));
    }
}
