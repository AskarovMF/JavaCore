package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> origin = new TreeSet<>();
        try {
            FileInputStream inputStream = new FileInputStream(args[0]);
            while (inputStream.available()>0){
                list.add(inputStream.read());
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        for (int i = 0; i < bite.length; i++) {
            System.out.println((char)bite[i] +" " + iteration[i]);
        }
    }
}
