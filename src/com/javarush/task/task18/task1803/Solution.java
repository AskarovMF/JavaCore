package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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
        int [] bite = new int[origin.size()];
        int index = 0;
        for (Integer x :
                origin) {
            bite[index] = x;
            index++;
        }
        int [] iteration = new int[bite.length];
        for (int i = 0; i < bite.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(bite[i])){
                    iteration[i]+=1;
                }
            }
        }
        int iterationIndex = 0;
        for (int i = 0; i <iteration.length; i++) {
            if (iterationIndex<iteration[i]) iterationIndex = iteration[i];
        }

        for (int i = 0; i <iteration.length; i++) {
            if (iterationIndex == iteration[i]){
                System.out.print(bite[i] + " ");
            }
        }
    }
}
