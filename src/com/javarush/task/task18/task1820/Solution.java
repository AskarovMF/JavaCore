package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file1 = new File(reader.readLine());
            File file2 = new File(reader.readLine());
            reader.close();
            BufferedReader input = new BufferedReader(new FileReader(file1));
            String str;
            List<Float> list = new ArrayList<>();
            while ((str = input.readLine())!= null){
                String[] subStr = str.split(" ");
                for (String x :
                        subStr) {
                    list.add(Float.parseFloat(x));
                }
            }
            input.close();
            BufferedWriter writer =new BufferedWriter(new FileWriter(file2));
            for (Float x :
                    list) {
                writer.write(Math.round(x) + " ");
            //    System.out.println(Math.round(x));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
