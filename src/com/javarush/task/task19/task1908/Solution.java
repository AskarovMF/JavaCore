package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter writer =new BufferedWriter(new FileWriter(reader.readLine()));

            while (fileReader.ready()){
                String string = fileReader.readLine();
                String[] subString = string.split(" ");
                for (String x :subString) {
                    if (x.matches("\\d+")){
                        writer.write(x + " ");
                    }
                }
            }
            fileReader.close();
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
