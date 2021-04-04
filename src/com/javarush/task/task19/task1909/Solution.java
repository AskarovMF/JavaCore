package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));

            while (fileReader.ready()){
                String string = fileReader.readLine();
                fileWriter.write(string.replaceAll("\\.", "\\!"));
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
