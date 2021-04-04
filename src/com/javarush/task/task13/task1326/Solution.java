package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine() )));) {

            while (buffer.ready()){
                int num = Integer.parseInt(buffer.readLine());
                if (num%2 == 0) list.add(num);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        int [] sortList = new int [list.size()];
        for (int i = 0; i<list.size(); i++) {
            sortList [i] = list.get(i);
        }
        Arrays.sort(sortList);
        for (int x: sortList) {
            System.out.println(x);
        }
    }
}
