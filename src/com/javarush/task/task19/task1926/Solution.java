package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(rd.readLine()));
            while (reader.ready()){
                String[] str = reader.readLine().split("");
                for (int i = str.length-1; i >=0 ; i--) {
                    System.out.print(str[i]);
                }
                System.out.println();
            }
            rd.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
