package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = rd.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()){
                String str = reader.readLine();
                for (Map.Entry<Integer, String> entry: map.entrySet()){
                    String num = String.valueOf(entry.getKey());
                        str = str.replaceAll("\\b"+num+"\\b", entry.getValue());
                }
                System.out.println(str);
            }
            reader.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
