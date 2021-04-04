package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader reader = new BufferedReader(new FileReader(rd.readLine()));

            while (reader.ready()){
                String string = reader.readLine();
                String [] str = string.split(" ");
                int count = 0;
                for (String x: str) {
                    for (String y : words) {
                        if (x.equals(y)) count++;
                    }
                  /*  if (x.equals(words.get(0))) count++;
                    else if (x.equals(words.get(1))) count++;
                    else if (x.equals(words.get(2))) count++;*/
                }
                if (count==2) System.out.println(string);
            }
            reader.close();
        }
        catch (IOException e){
            System.out.println("Ты облажался.");
        }
    }
}
