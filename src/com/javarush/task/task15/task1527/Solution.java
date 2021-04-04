package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String str = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String parametr = "[?]";
        String delimetr = "&";
        String delimetrPar = "=";
        ArrayList<String> list = new ArrayList<>();
        try {
            String [] subString = str.split(parametr); // разделяем по "?"
            if (subString[1].contains(delimetr)) {     // если содержит "&"
                String[] subStringParam = subString[1].split(delimetr);   // разделяем по "&"
                for (int i = 0; i < subStringParam.length; i++) {
                    String string = subStringParam[i];
                    if (string.contains(delimetrPar)) {
                       String [] parametrs = string.split(delimetrPar);
                        for (String x: parametrs) {
                            list.add(x);
                        }
                       System.out.print(parametrs[0] + " ");
                    } else System.out.print(string + " ");
                }
            } else System.out.println(subString[1]);

            for (int i = 0; i<list.size(); i++){
                if (list.get(i).contains("obj")) {
                    System.out.println();
                    try {
                        alert(Double.parseDouble(list.get(i+1)));
                    } catch (NumberFormatException e) {
                        alert(list.get(i+1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
