package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        try {
            while (!(string = reader.readLine()).equals("")){
                try {
                    FileInputStream inputStream = new FileInputStream(string);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(string);
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
