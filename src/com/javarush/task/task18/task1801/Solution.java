package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        String name;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name=reader.readLine();
            FileInputStream inputStream = new FileInputStream(name);
            while (inputStream.available()>0){
                int data = inputStream.read();
                list.add(data);
            }
            inputStream.close();
        }
        catch (IOException e){
            System.out.println("Файл не найден.");
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
}
