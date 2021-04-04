package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
            List<Integer> list = new ArrayList<>();
            Set<Integer> origin = new TreeSet<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String name = reader.readLine();
                FileInputStream inputStream = new FileInputStream(name);
                while (inputStream.available()>0){
                    int data = inputStream.read();
                    list.add(data);
                }
                inputStream.close();
            }
            catch (Exception e){
                System.out.println("Файл не найден.");
            }
            origin.addAll(list);
        for (Integer x :
                origin) {
            System.out.print(x + " ");
        }
        }
    }
