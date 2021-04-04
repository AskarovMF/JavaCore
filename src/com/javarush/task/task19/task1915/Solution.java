package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedWriter writer =new BufferedWriter(new FileWriter(reader.readLine()));
            FileOutputStream outputStream1 = new FileOutputStream("");
            outputStream1.close();
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);
            testString.printSomething();

            String result = outputStream.toString();
            System.setOut(consoleStream);
            System.out.println(result);
            writer.write(result);
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

