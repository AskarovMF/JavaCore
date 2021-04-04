package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String str;
        try {
            while (true){
                str = reader.readLine();
                if (str.equals("exit")) break;
                else list.add(str);

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String x :
                list) {
            new ReadThread(x).start();
        }
      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(resultMap);*/
    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            List<Integer> list = new ArrayList<>();
            Set<Integer> origin = new TreeSet<>();
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
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
                    resultMap.put(fileName, bite[i]);
                }
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
