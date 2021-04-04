package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id =Integer.parseInt(args[0]);
            BufferedReader inputReader = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            List<String []> list = new ArrayList<>();
            String str;
            while ((str = inputReader.readLine())!= null){
                list.add(str.split(" "));
            }
            inputReader.close();
            for (String[] x: list) {
                String[] subString = x;
                String subId = subString[0];
                int index = Integer.parseInt(subId);
                if (index== id) {
                    for (String y :
                            x) {
                        System.out.print(y + " ");
                    }
                }
            }
           // String [] subStr = found.split(" ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
