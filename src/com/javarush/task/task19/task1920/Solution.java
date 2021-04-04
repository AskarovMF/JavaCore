package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                } else { map.put(str[0], Double.parseDouble(str[1])); }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double maxValue = 0;
        for (Map.Entry<String, Double> entry:map.entrySet()){
            if (maxValue<entry.getValue()) maxValue = entry.getValue();
        }
        for (Map.Entry<String, Double> entry:map.entrySet()){
            if (maxValue==entry.getValue()) System.out.println(entry.getKey());
        }

    }
}
