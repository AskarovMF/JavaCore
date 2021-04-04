package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            String result = "";
            while (reader.ready()){
                String [] str = reader.readLine().split(" ");
                for (String x : str) {
                    if (x.length()>6){
                        result+=x+",";
                    }
                }
            }
            int lastIndex = result.lastIndexOf(",");
            result = result.substring(0,lastIndex);
            writer.write(result);
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
