package com.question.practice;

public class Main {

    public static void methodThree()
    {
        System.out.println("Three");
    }

    public static void methodTwo()
    {
        methodThree();
        System.out.println("Two");
    }

    public static void methodone()
    {
        methodTwo();
        System.out.println("One");
    }

    public static void main(String[] args) {
        methodone();

    }

}
