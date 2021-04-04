package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String[] result = outputStream.toString().split(" ");
        System.setOut(consoleStream);
        int one = Integer.parseInt(String.valueOf(result[0]));
        int two = Integer.parseInt(String.valueOf(result[2]));
        int plus = one + two;
        int minus = one - two;
    //    if (minus<0) minus= -(minus);
        int multiplication = one * two;
        switch (result[1]){
            case "+":
                System.out.println(one + " + " + two + " = " + plus);
                break;
            case "-":
                System.out.println(one + " - " + two + " = " + minus);
                break;
            case  "*":
                System.out.println(one + " * " + two + " = " + multiplication);
                break;
        }
      //  System.out.println(numbers);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

