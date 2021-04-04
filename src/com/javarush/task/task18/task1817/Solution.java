package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int i;
            int space = 32;
            int symbolSpace = 0;
            int overSymbol = 0;

            while ((i = fileInputStream.read())!=-1){
                overSymbol++;
                if (i==space) symbolSpace++;
            }
            fileInputStream.close();
            double result = (((double)symbolSpace)/(double)(overSymbol))*100;
            System.out.printf("%.2f", result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
