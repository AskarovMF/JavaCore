package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            int count = 0;
            while (fileReader.ready()){
                String str = (fileReader.readLine());
                String[] subStr = str.split("\\W+");
                for (String x:subStr) {
                    if (x.equals("world")) count++;
                }
            }
            fileReader.close();
            System.out.println(count);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
