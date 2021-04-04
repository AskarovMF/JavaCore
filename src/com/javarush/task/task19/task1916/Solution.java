package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        List<String> added = new ArrayList<>();
        List<String> removed = new ArrayList<>();
        List<String> same = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader reader1 = new BufferedReader(new FileReader(rd.readLine()));
            BufferedReader reader2 = new BufferedReader(new FileReader(rd.readLine()));
            while (reader1.ready()) {
                file1.add(reader1.readLine());
            }
            while (reader2.ready()) {
                file2.add(reader2.readLine());
            }
            reader1.close();
            reader2.close();

            for (String x : file1) {
                if (file2.contains(x)) {
                    same.add(x);
                } else removed.add(x);
            }

            for (String y : file2) {
                if (!file1.contains(y)) {
                    added.add(y);
                }
            }

            int indexAdded = added.size()-1;
            int indexRemoved = removed.size()-1;

            for (int i = same.size()-1; i >=0; i--) {
                lines.add(new LineItem(Type.SAME, same.get(i)));
                if (i%2==0){
                if (indexAdded>0){
                    lines.add(new LineItem(Type.ADDED, added.get(indexAdded)));
                    indexAdded--;
                } } else {
                    if (indexRemoved>0){
                        lines.add(new LineItem(Type.REMOVED, removed.get(indexRemoved)));
                        indexRemoved--;
                    }
                }
            }

          /*  for (LineItem x :
                    lines) {
                System.out.println(x.toString());
            }*/

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
