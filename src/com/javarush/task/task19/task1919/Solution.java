package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> map = new TreeMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){
                String [] str = reader.readLine().split(" ");
                if (map.containsKey(str[0])) {
                   double i =  map.get(str[0]) + Double.parseDouble(str[1]);
                   map.put(str[0], i);
                } else map.put(str[0], Double.parseDouble(str[1]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Double> entry:
        map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
