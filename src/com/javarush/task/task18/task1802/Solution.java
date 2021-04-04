package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name=reader.readLine();
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
        System.out.println(list.get(0));
    }
    }
