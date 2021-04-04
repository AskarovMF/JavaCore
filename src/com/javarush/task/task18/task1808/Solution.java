package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file1 = "", file2 = "", file3 = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream inputStream = new FileInputStream(file1);
            FileOutputStream outputStream1 = new FileOutputStream(file2);
            FileOutputStream outputStream2 = new FileOutputStream(file3);
            byte [] buffer = new byte[inputStream.available()+1];
            while (inputStream.available()>0){
                if (inputStream.available()%2==0){
                    int count = inputStream.read(buffer);
                    outputStream1.write(buffer,0,count/2);
                    outputStream2.write(buffer,count/2,count/2);
                } else {
                    int count = inputStream.read(buffer);
                    outputStream1.write(buffer,0,count/2+1);
                    outputStream2.write(buffer,count/2+1,count/2);
                }
            }
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
