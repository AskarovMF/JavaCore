package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader =new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            while (reader.ready()){
                String[] words = reader.readLine().split(" ");
                for (String x : words) {
                    String[] chars = x.split("");
                    for (String y : chars) {
                        if ((y).matches("\\d")) {
                            writer.write(x + " ");
                            break;
                        }
                    }
                  /*  if (x.matches("([a-zA-Z]+\\d+)|(\\d+[a-zA-Z]+)|([a-zA-Z]+\\d+[a-zA-Z]+)|(\\d+[a-zA-Z]+\\d+)")){
                        writer.write(x + " ");}*/
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
