package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "";
        String file2 = "";
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(file1);
            FileOutputStream outputStream = new FileOutputStream(file2);
            List<Integer> list = new ArrayList<>();
            while (inputStream.available()>0){
                int data = inputStream.read();
                list.add(data);
            }
            for (int i = list.size()-1; i >= 0; i--) {
                outputStream.write(list.get(i));
            }
            reader.close();
            inputStream.close();;
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
